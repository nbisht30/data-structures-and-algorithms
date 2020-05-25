package leetcode.randomproblems.dp;

class P509FibonacciNumber {
    int lookup[] = new int[31];
    
    public int fib(int N) {
        if(N == 0) return 0;
        int f = 0;
        if(lookup[N] != 0) return lookup[N];
        
        if(N <= 2) f = 1;
        else f = fib(N - 1) + fib(N - 2);
        lookup[N] = f;
        return f;
    }
}