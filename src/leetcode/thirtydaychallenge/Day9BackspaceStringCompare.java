package leetcode.thirtydaychallenge;

import java.util.Stack;

/**
 * @author Nikhil Bisht
 * @date 08-04-2020
 */
//https://leetcode.com/problems/backspace-string-compare/solution/
public class Day9BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompareTwoPointer("ab#c", "ad#c"));
    }

    public static boolean backspaceCompare(String S, String T) { //My solution: This is slow as you're using string concatenation. Even if we use string builder, because
        //we need to append at the begining, it would be done using the insert() which is same thing as string concatenation, therefore slower. Hence using stack is a faster impl.
        //TTS : 50 minutes. :(
        String stS = "", stT = "";
        int counth = 0;
        char temp;
        for (int i = S.length() - 1; i >= 0; i--) {
            temp = S.charAt(i);
            if (temp == '#') {
                counth++;
            } else {
                if (counth <= 0) {
                    stS = temp + stS;
                } else {
                    counth--;
                }
            }
        }
        counth = 0;
        for (int i = T.length() - 1; i >= 0; i--) {
            temp = T.charAt(i);
            if (temp == '#') {
                counth++;
            } else {
                if (counth <= 0) {
                    stT = temp + stT;
                } else {
                    counth--;
                }
            }
        }
        if (stT.equals(stS)) {
            return true;
        }
        return false;
    }

    public static boolean backspaceCompareTwoPointer(String S, String T) { //The idea is same as my implementation i.e we need to traverse from reverse. But I am counting # and removing simultaneously.
        // You dont need to do that, you need to just keep comparing the two strings simultaneously on finding each valid character i.e after ignoring all elements which were present after this
        // valid character and have been removed from backspaces.
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {  //// While there may be chars in build(S) or build (T)

            while (i >= 0) { // Finding a valid character in string S
                if (S.charAt(i) == '#') {
                    i--;
                    skipS++;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;  //valid character found
                }
            }

            while (j >= 0) { // Finding a valid character in string T
                if (T.charAt(j) == '#') {
                    j--;
                    skipT++;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;  //valid character found
                }
            }

            if (((i >= 0) && (j >= 0)) && S.charAt(i) != T.charAt(j)) { // If valid characters were found, but they were different.
                return false;
            }

            if ((i >= 0) != (j >= 0)) // If one of the strings finished before the other.
                return false;

            i--;
            j--;
        }
        return true;
    }

    public boolean backspaceCompareStack(String S, String T) { //Using Stack, self implemented with hint. Faster than using string concatenation.
        return getStringUsingStack(S).equals(getStringUsingStack(T));
    }

    public String getStringUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch != '#') {
                stack.push(ch);
            } else {
                if (!stack.empty())
                    stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
