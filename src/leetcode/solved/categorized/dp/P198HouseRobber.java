package leetcode.solved.categorized.dp;

class P198HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0; // if no house then cant rob
        if(nums.length == 1) return nums[0]; // if only one house rob it
        int dp[] = new int[nums.length];
        dp[0] = nums[0]; // if one house
        dp[1] = Math.max(nums[0], nums[1]); // if two houses exist 
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}