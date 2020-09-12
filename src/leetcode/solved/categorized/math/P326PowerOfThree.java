package leetcode.solved.categorized.math;

class P326PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // Find max int that is the power of 3 and check if it is a multiple of n
        // 1162261467 is 3^19,  3^20 is bigger than int  
        // This method would only work for power of primes.
        return n > 0 && (1162261467 % n == 0);
    }
    
    public boolean isPowerOfThreeWithLoop(int n) {
        if(n <= 0) return false;
        while(n > 1){
            if(n % 3 == 0) n = n / 3;
            else return false;
        }
        return true;
    }
}