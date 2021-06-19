package leetcode.categorized.graphs.connectedcomponents.kosaraju;

class P547NumberOfProvinces {
    // MYSELF
    // DATE: 09-06-21
    // TIME: 20 mins
    // INTUITION: Simply count connected components using Kosaraju's strongly connected components
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        boolean[] vis = new boolean[isConnected.length];
        for(int v = 0; v < isConnected.length; v++) {
            if(!vis[v]) {
                kosarajuScc(isConnected, vis, v, -1);
                cnt++;
            }
        }
        return cnt;
    }
    
    void kosarajuScc(int[][] isConnected, boolean[] vis, int vertex, int parent) {
        vis[vertex] = true;
        int[] neighbors = isConnected[vertex];
        for(int n = 0; n < neighbors.length; n++) {
            if(n != parent && n != vertex && !vis[n] && neighbors[n] == 1) kosarajuScc(isConnected, vis, n, vertex);
        }
    }
    
}