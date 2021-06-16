package leetcode.solved.categorized.graphs.sssp.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class P882ReachableNodesInSubdividedGraph {
    public static void main(String[] args) {
        P882ReachableNodesInSubdividedGraph s = new P882ReachableNodesInSubdividedGraph();
        int[][] edges = {{3,4,8},{0,1,3},{1,4,0},{1,2,3},{0,3,2},{0,4,10},{1,3,3},{2,4,3},{2,3,3},{0,2,10}};
        int maxMoves = 7;
        int n = 5;
        int reachableNodes = s.reachableNodes(edges, maxMoves, n);
        System.out.println(reachableNodes);
    }

    // @TODO: Resolve and understand fully
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph = getAdjMatrix(edges, n);
        int count = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.moves - a.moves); // need a max heap
        maxHeap.add(new Node(0, maxMoves));

        while (!maxHeap.isEmpty()) {
            Node fromNode = maxHeap.poll();
            int from = fromNode.index;
            if(visited[from]) continue;
            visited[from] = true;
            count++;

            int[] neighbors = graph[fromNode.index];
            for (int i = 0; i < neighbors.length; i++) {
                int edgeCost = neighbors[i], to = i, movesLeft = fromNode.moves;
                if (edgeCost < 0) continue;

                if(movesLeft > edgeCost && !visited[to]) {
                    maxHeap.offer(new Node(to, movesLeft - edgeCost - 1));
                }
                graph[to][from] -= Math.min(movesLeft, edgeCost);
                count += Math.min(movesLeft, edgeCost);

            }
        }
        return count;
    }

    int[][] getAdjMatrix(int[][] edges, int n) {
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjMatrix[i], -1); // because graph can have edges with 0 weight
        }
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
        int moves;

        Node(int index, int moves) {
            this.index = index;
            this.moves = moves;
        }
    }
}
