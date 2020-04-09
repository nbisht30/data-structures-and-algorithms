package leetcode.randomproblems.strings;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static int isValidChar(char ch) {
        if ((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90))
            return ch;
        else if ((ch >= 97 && ch <= 122))
            return (char) (ch - 32);
        else
            return 0;
    }

    public static boolean isPalindrome(String s) {
        int st = 0, en = s.length() - 1;
        String s1 = s.toUpperCase();
        while (st < en) {
            int stChar = s1.charAt(st);
            stChar = isValidChar((char) stChar);
            int enChar = s1.charAt(en);
            enChar = isValidChar((char) enChar);
            while (stChar != 0 && enChar == 0) {  //find a valid character at end
                // to compare with valid character already found at start, this kind of approach
                // saves unnecessary checking of validity for a valid character already found at start.
                en--;
                enChar = s1.charAt(en);
                enChar = isValidChar((char) enChar);
            }
            while (stChar == 0 && enChar != 0) {  //find a valid character at start
                // to compare with valid character already found at end
                st++;
                stChar = s1.charAt(st);
                stChar = isValidChar((char) stChar);
            }
            if (stChar != enChar) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
