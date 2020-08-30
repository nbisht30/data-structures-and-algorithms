package leetcode.solved.categorized.arrays.missingnumbers;

class P268MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expSum = n * (n + 1) / 2;  // Gauss Formula
        int sum = 0;
        for(int i : nums) sum += i;
        return expSum - sum;
    }
}