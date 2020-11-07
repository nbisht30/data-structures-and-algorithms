package leetcode.solved.categorized.dp;

import java.util.HashMap;
import java.util.Map;

class P91DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return Integer.parseInt(s) == 0 ? 0 : 1;

        Map<String, Integer> dp = new HashMap<>();
        return helper(s, 0, dp);
    }

    int helper(String s, int index, Map<String, Integer> dp) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') return 0;

        String key = s.substring(index, s.length());

        if (dp.containsKey(key)) return dp.get(key);

        int count = 0;
        dp.put(key, count);

        if (index + 1 < s.length() && s.charAt(index + 1) == '0') {

            int num = Integer.parseInt(s.substring(index, index + 2));
            if (num == 10 || num == 20) {
                count = helper(s, index + 2, dp);
                dp.put(key, count);
            }

        } else {

            count = helper(s, index + 1, dp);
            dp.put(key, count);

            if (index + 1 < s.length()) {
                int num = Integer.parseInt(s.substring(index, index + 2));
                if (num > 0 && num < 27) {
                    count += helper(s, index + 2, dp);
                }
                dp.put(key, count);
            }

        }

        return dp.get(key);
    }
}