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
        // Vertical scanning

        if(strs == null || strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++){

            char ch = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || ch != strs[j].charAt(i))
                    return strs[0].substring(0 , i);
            }

        }

        return strs[0];
    }

    /*
    Horizontal Scanning - Comparing i-th string  with i + 1 th string one by one.
     */
    public String longestCommonPrefixHorizontalScanning(String[] strs) {
        if(strs.length == 1) return strs[0];
        String currPrefix = "";
        for(int i = 0; i < strs.length - 1; i++){
            int j = 0;
            for(j = 0; j < Math.min(strs[i].length(), strs[i + 1].length()); j++){
                if(strs[i].charAt(j) == strs[i + 1].charAt(j)) continue;
                else break;
            }
            strs[i + 1] = strs[i + 1].substring(0 , j);
            currPrefix = strs[i + 1];
            if(currPrefix.isEmpty()) return "";
        }
        return currPrefix;
    }
}