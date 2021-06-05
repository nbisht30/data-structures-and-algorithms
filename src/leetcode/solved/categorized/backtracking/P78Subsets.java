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

    // MYSELF
    // DATE: 05-06-21, second attempt
    // TIME: 9:11 mins
    class SecondAttempt {
        List<List<Integer>> subsetList = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            findSubsets(nums, new ArrayList<>(), 0);
            return subsetList;
        }

        void findSubsets(int[] nums, List<Integer> subset, int st) {
            if(st >= nums.length) {
                subsetList.add(new ArrayList<>(subset));
                return;
            }

            findSubsets(nums, subset, st + 1);
            subset.add(nums[st]);
            findSubsets(nums, subset, st + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
