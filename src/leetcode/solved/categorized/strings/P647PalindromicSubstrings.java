package leetcode.solved.categorized.strings;

class P647PalindromicSubstrings {
    // O(n^3) approach
    // @TODO: DP approach
    // @TODO: Expand Around Center approach
    public int countSubstrings(String s) {
        int count = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + len < s.length(); j++) {
                if (isPalin(s, j, j + len)) count++;
            }
            len++;
        }
        return count;
    }

    boolean isPalin(String str, int st, int end) {
        for (int i = st, j = end; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }

    /* O(n^2) approach
    Expand from middle approach (This is the fastest algo for this problem, even faster than the dynamic programming algo)
    Video: https://www.youtube.com/watch?v=y2BD4MJqV20&ab_channel=NickWhite
    Intuition: https://leetcode.com/problems/palindromic-substrings/discuss/884357/EXPLANATION-or-Expand-form-middle-approach
     */
        public int countSubstringsExpandFromMiddle(String s) {
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                int oddLenPalins = countUsingExpandFromMiddle(s, i, i);
                int evenLenPalins = countUsingExpandFromMiddle(s, i, i + 1);
                count += oddLenPalins + evenLenPalins;
            }
            return count;
        }

        int countUsingExpandFromMiddle(String s, int left, int right){
            if(s == null || s.length() == 0 || left > right) return 0;
            int countPalindromes = 0;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                countPalindromes++;
            }
            return countPalindromes;
        }
}