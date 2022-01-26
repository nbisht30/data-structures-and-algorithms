package leetcode.categorized.dp.twodimensional;

class P62UniquePaths {
    class Tabulation {
        // Bottom Up
        public int uniquePaths(int m, int n) {
            // IMP:  Either down or right
            int dp[][] = new int[m][n];

            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    else if (i > 0) dp[i][j] = dp[i - 1][j];
                    else if (j > 0) dp[i][j] = dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    class MemoizedSolution {
        // Top Down
        // DATE: 23/Jan/22
        // TC: O(m*n) SC: O(m * n )
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            return ways(m, n, dp);
        }

        int ways(int m, int n, int[][] dp) {
            if (m == 1 && n == 1) return 1;
            if (m == 0 || n == 0) return 0;

            if (dp[m][n] > 0) return dp[m][n];

            int up = ways(m - 1, n, dp);
            int left = ways(m, n - 1, dp);

            dp[m][n] = up + left;

            return dp[m][n];
        }
    }
}