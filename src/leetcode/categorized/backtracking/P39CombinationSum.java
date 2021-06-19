package leetcode.categorized.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    void backtrack(int[] candidates, List<Integer> temp, List<List<Integer>> result, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, temp, result, remain - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}