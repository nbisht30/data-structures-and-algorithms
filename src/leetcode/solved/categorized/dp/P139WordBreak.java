package leetcode.solved.categorized.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P139WordBreak {
     Map<String, Boolean> dpMap = new HashMap<>();
    public boolean wordBreakDpRecursiveBottomUp(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(dpMap.containsKey(s)) return dpMap.get(s);
        int currInd = 0;
        while(currInd < s.length()){
            String left = s.substring(0, currInd + 1);
            String right = s.substring(currInd + 1);
            if(wordDict.contains(left) && wordBreakDpRecursiveBottomUp(right, wordDict)){
                dpMap.put(left, true);
                return true;
            }else currInd++;
        }
        dpMap.put(s, false);
        return false;
    }

    public boolean wordBreakIterativeBottomUpOptimized(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // This is a replacement of dpMap in the wordBreakDpRecursiveBottomUp implementation
        dp[0] = true; // substring(0,0) i.e. an empty string can be broken into words from dict
        for(int i = 1; i <= s.length(); i++){ // iterate n number of times (basically replacing the recursive calls)
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}