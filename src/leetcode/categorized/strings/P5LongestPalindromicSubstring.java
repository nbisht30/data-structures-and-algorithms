package leetcode.categorized.strings;

class P5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        int max;
        int st = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int oddLenPalin = expandFromMiddle(s, i, i);
            int evenLenPalin = expandFromMiddle(s, i, i + 1);
            
            max = Math.max(oddLenPalin, evenLenPalin);
            if(max > end - st){
                st = i - ((max - 1) / 2);
                end = i + max / 2;
            }
        }
        
        return s.substring(st, end + 1);
    }
    
    int expandFromMiddle(String s, int left, int right){
        if(s == null || s.length() == 0 || left > right) return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            right++;
            left--;
        }
        
        return right - left - 1;
    }
}