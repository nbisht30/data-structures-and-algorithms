package leetcode.solved.categorized.graphs.connectedcomponents.kosaraju;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class P1319NumberOfOperationsToMakeNetworkConnected {

    // MYSELF
    // TIME: 30 mins
    // DATE: 09-06-21, first attempt
    // APPROACH: Kosaraju SCC
    // If number of edges is less then number of vertices - 1 then return -1
    // else find number of connected components and edges required = connComp - 1
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges < n - 1) return -1; // To connect all nodes need at least n-1 edges
        boolean[] visited = new boolean[n];
        int connectedComp = 0;
        Map<Integer, ArrayList<Integer>> graph = getGraph(n, connections);
        for(int v = 0; v < n; v++) {
            if(!visited[v]) {
                connectedComp++;
                kosarajuScc(graph, visited, v, -1);
            }
        }

        int edgesReq = connectedComp - 1;
        return edgesReq;
    }

    Map<Integer, ArrayList<Integer>> getGraph(int n, int[][] connections) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < connections.length; i++) {
            int st = connections[i][0];
            int end = connections[i][1];
            graph.get(st).add(end);
            graph.get(end).add(st);
        }
        return graph;
    }

    void kosarajuScc(Map<Integer, ArrayList<Integer>> graph, boolean[] visited, int curVertex, int parent) {
        visited[curVertex] = true;
        ArrayList<Integer> neighbors = graph.get(curVertex);
        for(int i = 0; i < neighbors.size(); i++) {
            int n = neighbors.get(i);
            if(n != parent && !visited[n]) kosarajuScc(graph, visited, n, curVertex);
        }
    }
}