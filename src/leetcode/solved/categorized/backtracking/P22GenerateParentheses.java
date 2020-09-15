package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, n);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder sb, int open, int close){
        if(open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }
        
        if(open > 0 && open <= close) {
            helper(res, new StringBuilder(sb).append('('), open - 1, close);
        }
        if(open < close) {
            helper(res, new StringBuilder(sb).append(')'), open, close - 1);
        }
    }
}