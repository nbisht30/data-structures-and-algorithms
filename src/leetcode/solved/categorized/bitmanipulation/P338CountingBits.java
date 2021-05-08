package leetcode.solved.categorized.bitmanipulation;

class P338CountingBits {
    // MYSELF
    // Based on concepts in : P191 Number Of Bits
    // TIME: 8 mins
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        
        for(int i = 0; i <= num; i++) {
            arr[i] = numberOfOnes(i);
        }
        return arr;
    }
    
    int numberOfOnes(int n) {
        int cnt= 0;
        while(n > 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }
}