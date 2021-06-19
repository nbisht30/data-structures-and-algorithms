package leetcode.categorized.backtracking;

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


    // MYSELF
    // DATE: 05-06-2021, second attempt
    // TIME: 20 mins
    class SecondAttempt {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            combinations(new StringBuilder(), res, 0, 0, n);
            return res;
        }

        void combinations(StringBuilder input, List<String> res, int startCnt, int closeCnt, int n) {
            if(startCnt < closeCnt || startCnt > n) return;

            if(input.length() == n * 2) {
                res.add(input.toString());
                return;
            }

            input.append("(");
            combinations(input, res, startCnt + 1, closeCnt, n);
            if(input.length() > 1) input.setLength(input.length() - 1);

            input.append(")");
            combinations(input, res, startCnt, closeCnt + 1, n);
            if(input.length() > 1) input.setLength(input.length() - 1);

        }

    }

}