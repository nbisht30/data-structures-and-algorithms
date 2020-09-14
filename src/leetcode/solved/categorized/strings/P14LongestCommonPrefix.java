package leetcode.solved.categorized.strings;

import java.util.Arrays;

class P14LongestCommonPrefix {
    // Using sorting
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);

        int size = strs[0].length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            } else {
                count++;
            }
        }

        return count == 0 ? "" : strs[0].substring(0, count);
    }

    // Comparing all strings, almost the same runtime as sorting implementation
    public String longestCommonPrefixCompareAllStrings(String[] strs) {
        // Vertical scanning method
        if(strs == null || strs.length == 0) return "";

        for(int k = 0; k < strs[0].length(); k++){

            char ch = strs[0].charAt(k);

            for(int i = 1; i < strs.length; i++){
                if(k == strs[i].length() || strs[i].charAt(k) != ch){
                    return strs[0].substring(0, k);
                }
            }
        }
        return strs[0];
    }
}