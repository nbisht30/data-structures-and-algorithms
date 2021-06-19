package leetcode.categorized.graphs;

class P1791FindCenterOfStarGraph {
    // MYSELF
    // DATE: 02-06-2021
    // TIME: 1 min

    public int findCenter(int[][] edges) {
        int[] e1 = edges[0];
        int[] e2 = edges[1];

        for (int v1 : e1) {
            for (int v2 : e2) if (v1 == v2) return v1;
        }
        return -1;
    }
}