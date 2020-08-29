package leetcode.solved.categorized.arrays;

class P485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int m = 0;
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) m++;
            else m = 0;
            if(m > mx) mx = m;
        }
        return mx;
    }
}