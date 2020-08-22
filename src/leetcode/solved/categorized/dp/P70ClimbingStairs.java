package leetcode.solved.categorized.dp;

class P70ClimbingStairs {
    //MYSELF
    //TIME: 9 MIN
    //APPROACH: DYNAMIC PROGRAMMING
    public int climbStairs(int n) {
        return helper(n, 0);
    }

    public int helper(int n, int c) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a[] = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}