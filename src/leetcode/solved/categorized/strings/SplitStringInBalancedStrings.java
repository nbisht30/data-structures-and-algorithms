package leetcode.solved.categorized.strings;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
/*https://leetcode.com/problems/split-a-string-in-balanced-strings/*/
public class SplitStringInBalancedStrings {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) { //TTS: 9.5 minutes
        int charR = 0, charL = 0;
        char[] charStr = s.toCharArray();
        int ctr = 0;
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] == 'R') {
                charR++;
            } else {
                charL++;
            }
            if (charR == charL) {
                ctr++;
                charL = 0;
                charR = 0;
            }
        }
        return ctr;
    }
}
