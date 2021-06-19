package leetcode.categorized.dp.kadanes;

class P152MaximumProductSubarray {
    /*
    EXPLANATION: https://medium.com/@aliasav/algorithms-maximum-product-subarray-b09e520b4baf
    We approach this problem bottom-up, such that at each iteration we will have the max possible subarray product.

    Consider this, at each iteration over the nums array, the max product can be obtained:

          - by multiplying nums[i] to a previous max product(max product till i-1th element)

          - by multiplying nums[i] to a previous min product(min product till i-1th element)
            (since both these nums[i] and previous min product might be negative,
             it’s worthwhile to compute this value)

          - nums[i] might itself be the largest
     */

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prevMin = nums[0], prevMax = nums[0], res = nums[0];
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = prevMin; // temporarily store prevMin to calculate prevMax later
            prevMin = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            prevMax = Math.max(nums[i], Math.max(nums[i] * temp, nums[i] * prevMax));
            res = Math.max(res, prevMax);
        }
        return res;
    }
}