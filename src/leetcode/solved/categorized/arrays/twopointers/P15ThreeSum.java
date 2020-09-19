package leetcode.solved.categorized.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P15ThreeSum {
    /*
    Best explanations:-
    https://www.youtube.com/watch?v=nZyzf4ZxHWA&ab_channel=NareshGupta
    https://www.youtube.com/watch?v=qJSPYnS35SE&ab_channel=NickWhite
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        int N = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // For our algorithm -> We move j forward to get a larger element when sum < 0, to reach our goal of sum = 0;
        // We move k backward to get a smaller element when sum > 0, to reach our goal of sum = 0;

        for (int i = 0; i < N - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int j = i + 1, k = N - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        while (j < k && nums[j] == nums[j + 1]) j++; // Ignoring duplicates
                        while (j < k && nums[k] == nums[k - 1]) k--; // Ignoring duplicates
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // If we've found the correct sum then we need to decrement both as well.
                        j++;
                        k--;
                    } else if (sum > 0) k--;
                    else j++;
                }
            }
        }
        return list;
    }
}