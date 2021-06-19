package leetcode.categorized.strings;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
//https://leetcode.com/problems/valid-palindrome/
public class P125ValidPalindrome {

    // MYSELF
    // TIME: 15
    // DATE: 11-May-21, second attempt
    // COMMENTS: Improvement from first attempt, cleaned up the code.
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j) {

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(i < j && s.charAt(i) != s.charAt(j)) return false;
            j--;
            i++;
        }
        return true;
    }
}
