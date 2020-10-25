package leetcode.solved.categorized.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P139WordBreak {
    Map<String, Boolean> dpMap = new HashMap<>();

    public boolean wordBreakDpRecursiveBottomUp(String s, List<String> wordDict) {
        if (wordDict.contains(s)) return true;
        if (dpMap.containsKey(s)) return dpMap.get(s);
        int currInd = 0;
        while (currInd < s.length()) {
            String left = s.substring(0, currInd + 1);
            String right = s.substring(currInd + 1);
            if (wordDict.contains(left) && wordBreakDpRecursiveBottomUp(right, wordDict)) {
                dpMap.put(left, true);
                return true;
            } else currInd++;
        }
        dpMap.put(s, false);
        return false;
    }

    public boolean wordBreakIterativeBottomUpOptimized(String s, List<String> wordDict) {
        // Explanation: https://www.youtube.com/watch?v=hLQYQ4zj0qg&ab_channel=GeeksforGeeks
        boolean[] dp = new boolean[s.length() + 1]; // This is a replacement of dpMap in the wordBreakDpRecursiveBottomUp im
        dp[0] = true; // substring(0,0) i.e. an empty string
        for (int len = 1; len <= s.length(); len++) { // iterate n number of times (basically replacing the recursive calls)
            for (int i = 0; i < len; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, len))) {
                    /*
                    Explanation:-
                    If for any value of i we have dp[i] as true i.e. substring(0, i) can be broken into words from dict
                    then if remaining substring that starts from i and goes till len - 1 is also present in wordDict
                    then basically dp[len] can be set to true.
                     */
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakIterativeTopDownOptimized(String s, List<String> wordDict) {
        // Explanation: https://www.youtube.com/watch?v=hLQYQ4zj0qg&ab_channel=GeeksforGeeks
        boolean[] dp = new boolean[s.length() + 1]; // This is a replacement of dpMap in the wordBreakDpRecursiveBottomUp im
        dp[0] = true; // substring(0,0) i.e. an empty string
        for (int len = 1; len <= s.length(); len++) { // iterate n number of times (basically replacing the recursive calls)
            for (int i = len - 1; i >= 0; i--) {
                /*
                In Top Down approach you basically start from the end and check the same condition,
                this can help in optimizing the performance as you might have a larger string already present in the wordDict
                 */
                if (dp[i] && wordDict.contains(s.substring(i, len))) {
                    /*
                    Explanation:-
                    If for any value of i we have dp[i] as true i.e. substring(0, i) can be broken into words from dict
                    then if remaining substring that starts from i and goes till len - 1 is also present in wordDict
                    then basically dp[len] can be set to true.
                     */
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}