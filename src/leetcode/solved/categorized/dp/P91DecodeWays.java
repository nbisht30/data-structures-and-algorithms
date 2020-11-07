package leetcode.solved.categorized.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class P91DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        Map<String, Integer> dp = new HashMap<>();
        return helperMapBasedDP(s, 0, dp);
    }

    int helperMapBasedDP(String s, int index, Map<String, Integer> dp) {
        if (index == s.length()) {
            dp.put(s, 1);
            return 1;
        }

        String key = s.substring(index);
        if (s.charAt(index) == '0') {
            dp.put(key, 0);
            return 0;
        }

        if (index == s.length() - 1) {
            dp.put(key, 1);
            return 1;
        }

        if (dp.containsKey(key)) return dp.get(key);

        int count = helperMapBasedDP(s, index + 1, dp);

        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += helperMapBasedDP(s, index + 2, dp);
        }

        dp.put(key, count);
        return dp.get(key);
    }

    // https://www.youtube.com/watch?v=9Ky-lgdaJUE&ab_channel=codebix
    public int numDecodingsArrayBasedDPTopDown(String s) { // Memoization / Top Down approach
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helperArrayBasedDPTopDown(s, 0, dp);
    }

    int helperArrayBasedDPTopDown(String s, int index, int[] dp) {
        if (index == s.length()) {
            dp[s.length() - 1] = 1;
            return 1;
        }

        if (s.charAt(index) == '0') {
            dp[index] = 1;
            return 0;
        }

        if (index == s.length() - 1) {
            dp[index] = 1;
            return 1;
        }

        if (dp[index] >= 0) return dp[index];

        int count = helperArrayBasedDPTopDown(s, index + 1, dp);

        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += helperArrayBasedDPTopDown(s, index + 2, dp);
        }

        dp[index] = count;
        return dp[index];
    }

    public int numDecodingsBottomUpDP(String s) {
        if (s.length() == 0) return 0;
        return helperBottomUp(s);
    }

    int helperBottomUp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            int lastDig = Integer.parseInt(s.substring(i - 1, i));
            int twoDig = Integer.parseInt(s.substring(i - 2, i));

            if (lastDig >= 1 && lastDig <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDig >= 10 && twoDig <= 26) {
                dp[i] += dp[i - 2];
            }

        }

        return dp[s.length()];
    }
}