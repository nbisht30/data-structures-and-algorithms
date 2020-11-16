package leetcode.solved.categorized.graphs.dfs;

import java.util.Arrays;

class P329LongestIncreasingPathInAMatrix {
    // DID IT MYSELF! Time: 30 mins
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxLen = 0;

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(cache[i][j] <= 0)
                    dfsLongest(matrix, i, j, Integer.MIN_VALUE, cache);
                maxLen = Math.max(maxLen, cache[i][j]);
            }
        }

        return maxLen;
    }

    int dfsLongest(int[][] matrix, int i, int j, int prev, int[][] cache){
        if(i < 0 || j < 0 || i >= matrix.length
                || j >= matrix[0].length || matrix[i][j] <= prev) return 0;

        if(cache[i][j] > 0) return cache[i][j];

        int a = dfsLongest(matrix, i + 1, j, matrix[i][j], cache);
        int b = dfsLongest(matrix, i - 1, j, matrix[i][j], cache);
        int c = dfsLongest(matrix, i, j + 1, matrix[i][j], cache);
        int d = dfsLongest(matrix, i, j - 1, matrix[i][j], cache);

        cache[i][j] = Math.max(a, Math.max(b, Math.max(c, d))) + 1;

        return cache[i][j];
    }
}