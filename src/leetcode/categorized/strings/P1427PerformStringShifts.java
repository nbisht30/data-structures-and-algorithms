package leetcode.categorized.strings;

public class P1427PerformStringShifts {

    public static String stringShift(String s, int[][] shift) {
        int length = s.length();
        int relativeShift = 0;
        for (int[] sh : shift) {
            if (sh[0] == 0) relativeShift -= sh[1];
            else relativeShift += sh[1];
        }
        relativeShift %= length;
        if (relativeShift < 0) return rotate(getCharString(s, length), 0, -1 * relativeShift);
        else return rotate(getCharString(s, length), 1, relativeShift);
    }

    private static char[] getCharString(String s, int length) {
        char[] newChar = new char[length * 2];
        for (int i = 0; i < length; i++) {
            newChar[i + length] = newChar[i] = s.charAt(i);
        }
        return newChar;
    }

    public static String rotate(char[] str, int leftOrRight, int nR) {
        int i;
        if (leftOrRight == 0) i = nR;
        else i = str.length / 2 - nR;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < str.length / 2; j++) {
            sb.append(str[i + j]);
        }
        return sb.toString();
    }
}
