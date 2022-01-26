package leetcode.categorized.dp.twodimensional;

import java.util.HashMap;
import java.util.Map;

class Solution {

    class RecursiveSolution {

        public int findTargetSumWays(int[] nums, int target) {
            return countExp(nums, 0, target);
        }

        int countExp(int[] nums, int i, int target) {
            if (i == nums.length) {
                if (target == 0) {
                    return 1;
                }
                return 0;
            }

            int waysWithPlus = countExp(nums, i + 1, target - nums[i]);
            int waysWithMinus = countExp(nums, i + 1, target + nums[i]);

            return waysWithPlus + waysWithMinus;
        }

    }

    class MemoizedSolution {

        public int findTargetSumWays(int[] nums, int target) {
            Map<String, Integer> cache = new HashMap<>();
            return countExp(nums, cache, 0, target, 0);
        }

        int countExp(int[] nums, Map<String, Integer> cache, int index, int target, int currSum) {
            if (index == nums.length) {
                return target == currSum ? 1 : 0;
            }

            String cacheKey = index + "," + currSum;
            if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

            int countWithPlus = countExp(nums, cache, index + 1, target, currSum + nums[index]);
            int countWithMinus = countExp(nums, cache, index + 1, target, currSum - nums[index]);

            cache.put(cacheKey, countWithPlus + countWithMinus);

            return cache.get(cacheKey);
        }

    }

}