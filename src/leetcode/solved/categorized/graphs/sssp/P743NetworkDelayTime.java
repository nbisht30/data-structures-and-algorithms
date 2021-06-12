package leetcode.solved.categorized.graphs.sssp;

import java.util.*;

class P743NetworkDelayTime {
    // DIJKSTRA'S ALGORITHM
    // MYSELF
    public static void main(String[] args) {
        P743NetworkDelayTime ndt = new P743NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int totalTime = ndt.networkDelayTime(times, n, k);
        System.out.println(totalTime);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        LinkedList<Pair>[] adjList = getAdjList(times, n);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        int[] dist = getDistUsingDijkstrasAlgorithm(n, k, adjList, visited, pq);
        Integer maxTime = getMaxTime(dist);
        if (maxTime == null) return -1;
        return maxTime;
    }

    private Integer getMaxTime(int[] dist) {
        int maxTime = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // if even one node was not visited, since we have to visit all node
                return null;
            } else {
                maxTime = Math.max(dist[i], maxTime);
            }
        }
        return maxTime;
    }

    private int[] getDistUsingDijkstrasAlgorithm(int n, int k, LinkedList<Pair>[] adjList, boolean[] visited, PriorityQueue<Pair> pq) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            visited[pair.vertex] = true;
            if (dist[pair.vertex] < pair.cost) continue; // can we change to <=
            LinkedList<Pair> edges = adjList[pair.vertex];
            if(edges == null) continue;
            Iterator<Pair> itr = edges.iterator();
            if (Objects.nonNull(itr)) {
                while (itr.hasNext()) {
                    Pair edge = itr.next();
                    if (visited[edge.vertex]) continue;
                    int newDist = dist[pair.vertex] + edge.cost;
                    if (newDist < dist[edge.vertex]) {
                        dist[edge.vertex] = newDist;
                        pq.offer(new Pair(edge.vertex, newDist));
                    }
                }
            }
        }
        return dist;
    }


    LinkedList<Pair>[] getAdjList(int[][] times, int n) {
        LinkedList<Pair>[] adjList = new LinkedList[n + 1];
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            if (adjList[from] == null) adjList[from] = new LinkedList<>();
            adjList[from].add(new Pair(to, cost));
        }
        return adjList;
    }

    class Pair {
        int vertex;
        int cost;

        Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}