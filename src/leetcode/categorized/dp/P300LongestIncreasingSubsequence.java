package leetcode.categorized.dp;

class P300LongestIncreasingSubsequence {

    //  @TODO: O(NLOGN) approach
    // Subsequence - Need not be contiguous.
    // Below approach is N^2 approach
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        return helper(nums, -1, 0, dp);
    }
    
    int helper(int[] nums, int prev, int curr, int[][] dp){
        if(curr == nums.length) return 0;

        if(prev != -1 && dp[prev][curr] != 0){
            return dp[prev][curr];
        }
        
        int op1 = 0, op2 = 0;

        if(prev == -1 || nums[prev] < nums[curr]){
            op1 = 1 + helper(nums, curr, curr + 1, dp);
        }
        op2 = helper(nums, prev, curr + 1, dp);
        
        if(prev != -1)
            dp[prev][curr] = Math.max(op1, op2);
        
        return Math.max(op1, op2);
    }
        
}