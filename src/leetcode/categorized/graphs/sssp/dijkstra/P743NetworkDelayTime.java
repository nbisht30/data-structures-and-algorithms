package leetcode.categorized.graphs.sssp.dijkstra;

import java.util.*;

class P743NetworkDelayTime {
    // MYSELF
    public int networkDelayTime(int[][] times, int n, int k) {
        LinkedList<Pair>[] adjList = getAdjList(times, n);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        int[] dist = getDistUsingDijkstrasAlgorithm(n, k, adjList, visited, pq);
        return getMaxTime(dist);
    }

    private int getMaxTime(int[] dist) {
        int maxTime = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // if even one node was not visited, since we have to visit all node
                return -1;
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
            if (dist[pair.vertex] < pair.cost) continue;
            LinkedList<Pair> edges = adjList[pair.vertex];
            if (edges == null) continue;
            Iterator<Pair> itr = edges.iterator();
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