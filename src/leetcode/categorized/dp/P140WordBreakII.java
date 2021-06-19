package leetcode.categorized.dp;

import java.util.*;

class P140WordBreakII {
    // Basic solution with back-tracking : TLE
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);
        return helper(s, set);
    }

    List<String> helper(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) result.add("");
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (wordDict.contains(prefix)) {
                String suffixCandidate = s.substring(i + 1);
                List<String> suffixes = helper(suffixCandidate, wordDict);
                for (String str : suffixes) {
                    result.add(prefix + (str.equals("") ? "" : (" " + str)));
                }
            }
        }
        return result;
    }

    /*
    This problem can be optimized using dp as there are repeating sub-problems.
    DP: HOW TO MEMOIZE USING MAP
     */
    class DPMemoizationSolution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            HashMap<String, List<String>> dp = new HashMap<>();
            for (String str : wordDict) set.add(str);
            return helper(s, set, dp);
        }

        List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> dp) {
            List<String> result = new ArrayList<>();
            if (s.length() == 0) result.add("");
            if (dp.containsKey(s)) {
                return dp.get(s);
            }
            for (int i = 0; i < s.length(); i++) {
                String prefix = s.substring(0, i + 1);
                if (wordDict.contains(prefix)) {
                    String suffixCandidate = s.substring(i + 1);
                    List<String> suffixes = helper(suffixCandidate, wordDict, dp);
                    for (String str : suffixes) {
                        result.add(prefix + (str.equals("") ? "" : (" " + str)));
                    }
                }
            }
            dp.put(s, result);
            return result;
        }
    }
}