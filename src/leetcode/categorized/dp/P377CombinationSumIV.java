package leetcode.categorized.dp;

import java.util.Arrays;

class P377CombinationSumIV {
    // MYSELF
    // DATE: 04-07-21
    // TIME: 38 mins
    // APPROACH: DP - Top Down
    class FirstSolution {
        public int combinationSum4(int[] nums, int target) {
            int[] ways = new int[target + 1];
            ways[0] = 1;
            for (int i = 1; i <= target; i++) {
                if (ways[i] == 0) ways[i] = helper(nums, ways, i);
            }
            return ways[target] == -1 ? 0 : ways[target];
        }

        int helper(int[] nums, int[] ways, int target) {
            if (target < 0 || ways[target] == -1) return 0;
            if (target == 0) return 1;
            if (ways[target] > 0) return ways[target];

            for (int i = 0; i < nums.length; i++) {
                ways[target] += helper(nums, ways, target - nums[i]);
            }
            if (ways[target] == 0) ways[target] = -1;
            return ways[target];
        }
    }

    // MYSELF
    // DATE: 04-07-21
    // COMMENT: Without the outer loop.
    // APPROACH: DP - Top Down
    class SecondSolution {
        public int combinationSum4(int[] nums, int target) {
            int[] ways = new int[target + 1]; // Ways to make any target represented by index
            Arrays.fill(ways, -1); // Initially assume no target can be made
            ways[0] = 1; // One way of making 0 is by choosing no element from nums
            return helper(nums, ways, target);
        }

        int helper(int[] nums, int[] ways, int target) {
            if(ways[target] > -1) return ways[target];

            int countWaysForTarget = 0;
            for(int i = 0; i < nums.length; i++) {
                if(target - nums[i] >= 0)
                    countWaysForTarget += helper(nums, ways, target - nums[i]);
            }
            ways[target] = countWaysForTarget;
            return ways[target];
        }
    }

}