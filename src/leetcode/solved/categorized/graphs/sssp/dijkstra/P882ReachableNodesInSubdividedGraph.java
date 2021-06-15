package leetcode.solved.categorized.graphs.sssp.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

class P882ReachableNodesInSubdividedGraph {
    public static void main(String[] args) {
        P882ReachableNodesInSubdividedGraph s = new P882ReachableNodesInSubdividedGraph();
        int[][] edges = {{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}};
//        int[][] edges = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        int maxMoves = 12;
        int n = 4;
        int reachableNodes = s.reachableNodes(edges, maxMoves, n);
        System.out.println(reachableNodes);
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] adjMatrix = getAdjMatrix(edges, n);
        int reachableCount = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>
                (Comparator.comparingInt(a -> a.distFromSrc));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int[] neighbors = adjMatrix[node.index];
            for (int i = 0; i < neighbors.length; i++) {
                int cost = neighbors[i], to = i, from = node.index;

                if (cost <= 0) continue;
                int nextDist = cost;
                if(!visited[to]) nextDist++; // +1 for counting to node also if it was not visited
                int totalDist = node.distFromSrc + nextDist;
                if (totalDist >= maxMoves) {
                    nextDist = maxMoves - node.distFromSrc;
                    cost -= nextDist;
                } else {
                    visited[to] = true;
                    cost = 0;
                    pq.offer(new Node(to, totalDist));
                }
                adjMatrix[from][to] = cost;
                adjMatrix[to][from] = cost;
                reachableCount += nextDist;
            }
        }
        reachableCount++; // +1 since at least source node(0) is reachable
        return reachableCount;

    }

    int[][] getAdjMatrix(int[][] edges, int n) {
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int cost = edges[i][2];
            adjMatrix[from][to] = cost;
            adjMatrix[to][from] = cost;
        }
        return adjMatrix;
    }

    class Node {
        int index;
        int distFromSrc;

        Node(int index, int dist) {
            this.index = index;
            this.distFromSrc = dist;
        }
    }
}
