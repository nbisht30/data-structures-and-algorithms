package leetcode.categorized.strings;

class P1332RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        return isPalin(s) ? 1 : 2;
    }
    
    boolean isPalin(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
            if(s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}