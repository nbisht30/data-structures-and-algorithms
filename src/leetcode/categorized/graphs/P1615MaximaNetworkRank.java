package leetcode.categorized.graphs;

class P1615MaximaNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] degree = new int[n];

        for (int[] road : roads) {
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
            degree[road[0]]++;
            degree[road[1]]++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, degree[i] + degree[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return max;
    }
}