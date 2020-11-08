package leetcode.solved.categorized.hashing;

import java.util.Arrays;

class P128LongestConsecutiveSequence {
    public int longestConsecutiveUsingSorting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 1, currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Only if the elements are unequal, we need to check if our sequence has extended or broken
                if (nums[i] == nums[i - 1] + 1) currLen++;
                else {
                    maxLen = Math.max(currLen, maxLen);
                    currLen = 1;
                }
            }
        }
        return Math.max(currLen, maxLen);
    }
}