package leetcode.solved.categorized.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class P128LongestConsecutiveSequence {

    // O(N logN) approach using sorting
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

    //O(n) maps based solution
    public int longestConsecutiveUsingHashing(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : nums) map.put(i, true);
        for (int i : nums) if (map.containsKey(i - 1)) map.put(i, false);

        int maxLen = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == true)
                maxLen = Math.max(maxLen, findMaxLen(map, key));
        }

        return maxLen;
    }

    int findMaxLen(Map<Integer, Boolean> map, int key) {
        int len = 0;
        while (map.containsKey(key)) {
            len++;
            key++;
        }
        return len;
    }

}