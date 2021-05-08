package leetcode.solved.categorized.backtracking;

import java.util.*;

class P47PermutationsII {

    // Solution without set
    // TIME: O(n! * n) [Permutations for any string is n!, and multiplied with n because of the for loop used in
    // each recursive call]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        helper(nums, used, res, permutation);
        return res;
    }

    void helper(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> permutation){
        if(permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // If i is already used, ignore
            if(used[i]) continue;
            // If i is same as i-1 th element and i-1 th element is already used, ignore
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            permutation.add(nums[i]);
            helper(nums, used, res, permutation);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    // Set based solution. (Slow, because we're even considering the duplicate permutations and re-adding them to set)
    public List<List<Integer>> permuteUniqueUsingSet(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, 0, set);
        return new ArrayList<>(set);
    }

    void helper(int[] nums, int curr, Set<List<Integer>> set) {
        if (curr == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int x : nums) temp.add(x);
            set.add(temp);
            return;
        }

        for (int i = curr; i < nums.length; i++) {
            swap(nums, curr, i);
            helper(nums, curr + 1, set);
            swap(nums, curr, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}