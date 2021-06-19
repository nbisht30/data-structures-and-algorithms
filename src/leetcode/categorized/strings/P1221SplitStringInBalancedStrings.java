package leetcode.categorized.strings;

public class P1221SplitStringInBalancedStrings {

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
