package leetcode.solved.categorized.strings;

import java.util.Arrays;

class P796RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;

        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        if (Arrays.equals(s1, s2)) return true;
        for (int i = 0; i < A.length(); i++) {
            char first = s1[0];
            for (int j = 0; j < A.length() - 1; j++) {
                s1[j] = s1[j + 1];
            }
            s1[A.length() - 1] = first;
            if (Arrays.equals(s1, s2)) return true;
        }

        return false;
    }
}