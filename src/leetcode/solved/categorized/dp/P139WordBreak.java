package leetcode.solved.categorized.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P139WordBreak {
     Map<String, Boolean> dpMap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(dpMap.containsKey(s)) return dpMap.get(s);
        int currInd = 0;
        while(currInd < s.length()){
            String left = s.substring(0, currInd + 1);
            String right = s.substring(currInd + 1);
            if(wordDict.contains(left) && wordBreak(right, wordDict)){
                dpMap.put(left, true);
                return true;
            }else currInd++;
        }
        dpMap.put(s, false);
        return false;
    }
}