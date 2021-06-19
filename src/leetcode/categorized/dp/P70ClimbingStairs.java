package leetcode.categorized.dp;

class P70ClimbingStairs {
    // MYSELF
    //TIME: 9 mins

    // DATE: 27/Apr/21, Second Attempt
    // TIME: 6 mins
    public int climbStairs(int n) {
        return helper(n);
    }

    public int helper(int n) {
        if(n == 1) return 1;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}