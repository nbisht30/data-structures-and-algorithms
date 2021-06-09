package leetcode.solved.categorized.graphs.cycledetection;

class P684RedundantConnection {
    // MYSELF
    // DATE: 08-06-21, first attempt
    // TIME: 1 hour
    /* ALGORITHM:-
    Find all vertices that are a part of the only cycle that exists in the graph
    Then check for each edge, if both its vertices are a part of the cycle and return last such edge
     */
    boolean[] cycleVertices;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        cycleVertices = new boolean[n + 1];
        // Get a graph as adjacency matrix using the edges
        boolean[][] graph = getAdjacencyMatrix(edges);
        markCycleVertices(graph, new boolean[n+1] , 1, -1);

        // Find last edge: edge from the end, which is a part of the cycle.
        for(int i = n - 1; i >= 0; i--) {
            int begin = edges[i][0];
            int end = edges[i][1];
            if(cycleVertices[begin] && cycleVertices[end]) return edges[i];
        }
        
        return edges[0]; // return any random edge otherwise
    }
    
    boolean[][] getAdjacencyMatrix(int[][] edges) {
        int n = edges.length;
        boolean[][] graph = new boolean[n + 1][n + 1];
        for(int i = 0; i < n; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        return graph;
    }
    
    boolean markCycleVertices(boolean[][] graph, boolean[] currVis, int vertex, int parentVertex){
        // cycle has been found
        if(currVis[vertex]) {
            cycleVertices[vertex] = true; // put the vertex which starts the cycle
            return true;
        }
        
        boolean[] connections = graph[vertex];
        currVis[vertex] = true;
        
        for(int i = 1; i < connections.length; i++) {
            // if there exists an edge, and destination vertex is not also the parent vertex and cycle exists from this vertex
            if(connections[i] && i != parentVertex && markCycleVertices(graph, currVis, i, vertex)){
                if(cycleVertices[vertex]) return false; // if we again find the vertex which started the cycle (see line 44)) we start returning false to calling methods
                else cycleVertices[vertex] = true; // otherwise mark all vertices in the cycle
                return true;
            }
            
        }

        currVis[vertex] = false; // mark vertex as unvisited if cycle does not exist from any of its children and return false
        return false;
    }
}
