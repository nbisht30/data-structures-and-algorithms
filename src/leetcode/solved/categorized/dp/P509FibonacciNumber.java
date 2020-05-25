package leetcode.solved.categorized.dp;

class P509FibonacciNumber {
    int lookup[] = new int[31];

    // Top Down Approach : Memoization
    public int fib(int N) {
        if (N == 0) return 0;
        int f = 0;
        if (lookup[N] != 0) return lookup[N];

        if (N <= 2) f = 1;
        else f = fib(N - 1) + fib(N - 2);
        lookup[N] = f;
        return f;
    }

    // Bottom Up Approach : Tabulation
    public int fibBotUp(int N) {
        int cache[] = new int[N + 1];
        cache[0] = 0;
        cache[1] = cache[2] = 1;
        for (int i = 3; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }
}