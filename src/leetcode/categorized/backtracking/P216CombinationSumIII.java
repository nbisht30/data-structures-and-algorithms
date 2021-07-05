package leetcode.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P216CombinationSumIII {
    // MYSELF
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, 9, new ArrayList<>(), n);
        return combinations;
    }
    
    void backtrack(int k, int st, List<Integer> comb, int n) {
        if(k == 0) {
            if(n == 0) combinations.add(new ArrayList<>(comb));
            return;
        } else if(n < 0) return;
        
        for(int i = st; i - k >= 0; i--) {
            comb.add(i);
            backtrack(k - 1, i - 1, comb, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}