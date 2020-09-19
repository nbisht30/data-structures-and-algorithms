package leetcode.solved.categorized.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        int N = nums.length;

        for (int i = 0; i < N - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int j = i + 1, k = N - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
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