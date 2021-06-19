package leetcode.categorized.slidingwindow;

import java.util.HashSet;
import java.util.Set;

class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int ptrA = 0, ptrB = 0;
        while (ptrB < s.length()) {
            if (!set.contains(s.charAt(ptrB))) {
                set.add(s.charAt(ptrB));
                maxLen = Math.max(set.size(), maxLen);
                ptrB++;
            } else {
                set.remove(s.charAt(ptrA));
                ptrA++;
            }
        }
        return maxLen;
    }
}