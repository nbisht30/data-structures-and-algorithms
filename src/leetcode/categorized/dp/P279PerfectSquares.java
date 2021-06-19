package leetcode.categorized.dp;

class P279PerfectSquares {
    // Recursive
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        return dpHelper(n, dp);
    }

    int dpHelper(int n, int[] dp) {
        if (n < 0) return Integer.MAX_VALUE; // If number is less than 0 then there are infinite ways
        if (n == 0) return 0;
        if (dp[n] > 0) return dp[n];
        dp[n] = n;
        for (int i = 1; i * i <= n; i++) {
            dp[n] = Math.min(dpHelper(n - i * i, dp), dp[n]);
        }
        dp[n] = dp[n] + 1;
        return dp[n];
    }

    int rec(int n) {
        if (n < 0) return Integer.MAX_VALUE; // If number is less than 0 then there are infinite ways
        if (n == 0) return 0;
        int minWays = n;
        for (int i = 1; i * i <= n; i++) {
            minWays = Math.min(rec(n - i * i), minWays);
        }
        return minWays + 1;
    }
}

// Dry run for recursive impl. :-
// rec(12) -> minWays = min(rec(8), 12) = 2 -> returns 3
// rec(8) -> minWays = min(rec(4), 8) = 1 -> returns 2
// rec(4) -> minWays = min(rec(0), 4) = 0 -> returns 1 (i.e minWays + 1)
// rec(0) -> returns 0