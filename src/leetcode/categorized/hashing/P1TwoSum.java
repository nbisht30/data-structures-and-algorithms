package leetcode.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {

    // MYSELF
    // DATE: 09/18/20, second attempt
    public static int[] twoSum(int[] nums, int target) {
        // We don't need a list to store two indices when
        // target has two equal number of whom its a sum eg. target = 8 and there are two elements 4 and 4 in the array.
        // We will find the second elements index as one would already be in the map.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
