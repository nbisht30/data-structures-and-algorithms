package leetcode.thirtydaychallengeapril;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/

/*
You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

Example 1:
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"

Example 2:
Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
*/
public class Day14PerformStringShifts {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }*/
        /*char[] chars = new char[]{'g', 'e', 'e', 'k', 's', 'g', 'e', 'e', 'k', 's'};
        for (char c : rotate(chars, 1, 2)) {
            System.out.print(c + " ");
        System.out.println();
        }*/
        System.out.println(stringShift("abcdefg", m));
    }

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
