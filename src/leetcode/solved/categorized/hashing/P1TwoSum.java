package leetcode.solved.categorized.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class P1TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum3(new int[]{2, 7, 7, 15}, 14);
        for (int i : ints)
            System.out.print(i + " ");
        System.out.println();
    }

    public static int[] twoSum2(int[] nums, int target) {  //TTS: 27 mins.
        int arr[] = new int[2];
        int sum = 0;

        Map<Integer, List<Integer>> intCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (intCount.containsKey(nums[i])) {
                intCount.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                intCount.put(nums[i], list);
            }

            if ((target - nums[i]) == nums[i]) {
                if (intCount.get(nums[i]).size() == 2)
                    return toIntArray(intCount.get(nums[i]));
            } else {
                if (intCount.containsKey(target - nums[i])) {
                    arr[0] = intCount.get(nums[i]).get(0);
                    arr[1] = intCount.get(target - nums[i]).get(0);
                    return arr;
                }
            }
        }
        intCount.forEach((a, b) -> System.out.println(a + " " + b));
        return new int[0];
    }

    public static int[] twoSum3(int[] nums, int target) {  //This is same but the code is more optimized, as we dont need a list to store two indices when
        // target has two equal number of whom its a sum eg. target = 8 and there are two elements 4 and 4 in the array. We will find the second elements index as one would already be in the map.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
}
