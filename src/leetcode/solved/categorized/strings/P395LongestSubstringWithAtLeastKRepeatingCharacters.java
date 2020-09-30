package leetcode.solved.categorized.strings;

class P395LongestSubstringWithAtLeastKRepeatingCharacters {
    // DIVIDE AND CONQUER APPROACH
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n == 0 || n < k) return 0;
        if(k <= 1) return n;
        
        int[] count = new int[26];
        // Count the character occurences
        for(int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        
        // Find the point from which to split the string i.e. when character occured < k times
        int end = 0;
        while(end < n && count[s.charAt(end) - 'a'] >= k) end++;
        if(end >= n - 1) return end; //if all n or n-1(if only the last character repeated < k times) characters repeat k or more times, if yes return.
        
        int lenSubStr1 = longestSubstring(s.substring(0, end), k); // Recursively call for first part
        
        // Now, it might be that there are multiple consecutive characters that occured < k times, so ignore them while finding the next split point.
        while(end < n && count[s.charAt(end) - 'a'] < k) end++;
        
        int lenSubStr2 = longestSubstring(s.substring(end, n), k); // Recursively call for sencond part
        
        return Math.max(lenSubStr1, lenSubStr2);
    }
}