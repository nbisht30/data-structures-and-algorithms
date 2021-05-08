package leetcode.solved.categorized.arrays;

class P485MaxConsecutiveOnes {
    // TIME : 6 :44 mins
    public int findMaxConsecutiveOnes(int[] nums) {
        int streak = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 1) streak++;
            else {
                max = Math.max(streak, max);
                streak = 0;
            }
        }
        return Math.max(max, streak);
    }
}