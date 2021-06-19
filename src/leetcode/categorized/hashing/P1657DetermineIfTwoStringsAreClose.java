package leetcode.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

class P1657DetermineIfTwoStringsAreClose {
    // MYSELF
    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }

        boolean close = true;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                close = false;
            }
            if ((count1[i] > 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] > 0)) {
                return false;
            }
        }

        if (close) return true;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0) map1.put(count1[i], map1.getOrDefault(count1[i], 0) + 1);
            if (count2[i] > 0) map2.put(count2[i], map2.getOrDefault(count2[i], 0) + 1);
        }

        if (map1.size() != map2.size()) return false;
        for (int key : map1.keySet()) if (map1.get(key) != map2.get(key)) return false;
        return true;
    }
}