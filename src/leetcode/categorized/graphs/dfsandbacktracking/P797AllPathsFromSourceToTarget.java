package leetcode.categorized.graphs.dfsandbacktracking;

import java.util.ArrayList;
import java.util.List;

class P797AllPathsFromSourceToTarget {
    // MYSELF
    // DATE: 02-06-2021
    // TIME: 10 mins
    // APPROACH: DFS and Backtracking

    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new ArrayList<>(), 0);
        return paths;
    }

    // We dont need to use a visited array since the graph is a DAG
    void dfs(int[][] graph, List<Integer> path, int vertex) {
        if(vertex == graph.length - 1) { //reached last vertex
            List<Integer> temp = new ArrayList<>(path);
            temp.add(vertex);
            paths.add(temp);
            return;
        }

        path.add(vertex);
        for(int v : graph[vertex]) dfs(graph, path, v);
        path.remove(path.size() - 1);
    }
}