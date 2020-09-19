package leetcode.solved.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class P1TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 7, 15}, 14);
        for (int i : ints)
            System.out.print(i + " ");
        System.out.println();
    }

    // My code when I solved the problem second time on 09/18/2020 08:43
    public static int[] twoSum(int[] nums, int target) {
        //This is same but the code is more optimized, as we dont need a list to store two indices when
        // target has two equal number of whom its a sum eg. target = 8 and there are two elements 4 and 4 in the array. We will find the second elements index as one would already be in the map.
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
