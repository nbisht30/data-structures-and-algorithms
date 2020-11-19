package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}