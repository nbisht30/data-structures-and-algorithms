package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remaining, int currPtr) {
        if (remaining < 0) return;
        if (remaining == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = currPtr; i < candidates.length; i++) {
            if (i > currPtr && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, remaining - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}