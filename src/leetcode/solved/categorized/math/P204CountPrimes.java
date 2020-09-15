package leetcode.solved.categorized.math;

class P204CountPrimes {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        for(int i = 0; i <= n; i++) prime[i] = true;
        
        for(int i = 2; i <= n / i; i++){
            if(prime[i]){ // If i is prime then cross off the multiples of i(composite numbers)
                for(int j = i * i; j <= n; j+=i) prime[j] = false;
            }
        }
        
        int cnt = 0;
        for (int i = 2; i < n; i++) {
			if (prime[i]) cnt++;
		}
        return cnt;
    }
}