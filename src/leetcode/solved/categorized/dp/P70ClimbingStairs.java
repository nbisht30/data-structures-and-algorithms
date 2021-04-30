package leetcode.solved.categorized.dp;

class P70ClimbingStairs {
    //MYSELF
    //TIME: 9 MIN
    //APPROACH: DYNAMIC PROGRAMMING

    //Time(Second Attempt: 27/Apr/21) : 6 Mins
    public int climbStairs(int n) {
        return helper(n);s
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