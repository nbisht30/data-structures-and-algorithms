package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, int i, List<Integer> temp) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(res, nums, i + 1, temp);
        temp.remove(temp.size() - 1);
        helper(res, nums, i + 1, temp);
    }
}
