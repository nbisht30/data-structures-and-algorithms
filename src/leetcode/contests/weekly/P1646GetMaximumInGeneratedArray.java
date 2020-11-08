package leetcode.contests.weekly;

class P1646GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        // if(n == 2) return 1;
       
        int[] nums = new int[n + 1];
        int max = 1;
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 1; (2 * i + 1) <= n; i++){
            nums[2 * i] = nums[i];
            nums[2 * i + 1] = nums[i] + nums[i + 1];
            max = Math.max(nums[2 * i], Math.max(nums[2 * i + 1], max));
        }
        
        return max;
    }
}