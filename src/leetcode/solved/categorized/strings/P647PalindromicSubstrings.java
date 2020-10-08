package leetcode.solved.categorized.strings;

class P647PalindromicSubstrings {
    // @TODO: Manacher's Algorithm

    /*
    Brute Force: O(n^3) approach
     */
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
        for (int i = 0; i < s.length(); i++) {
            int oddLenPalins = countUsingExpandFromMiddle(s, i, i);
            int evenLenPalins = countUsingExpandFromMiddle(s, i, i + 1);
            count += oddLenPalins + evenLenPalins;
        }
        return count;
    }

    int countUsingExpandFromMiddle(String s, int left, int right) {
        if (s == null || s.length() == 0 || left > right) return 0;
        int countPalindromes = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            countPalindromes++;
        }
        return countPalindromes;
    }

    /*
    DP approach(O(n^2) space and time complexity - Slower than expand from middle)
    */
    public int countSubstringsDP(String s) {
        int n = s.length();
        if (n < 2)
            return n;
        int count = n;
        boolean[][] dp = new boolean[n][n];
        // size 1 substrings are palindromes
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        // for size 2 substrings, check first and last char
        for (int i = 0; i + 1 < n; i++)
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        // for size = 3+
        for (int len = 2; len < n; len++) // controls the size of the substring
            for (int i = 0; i + len < n; i++) { // controls the start index
                int j = i + len; // end index
                if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        return count;
    }
}