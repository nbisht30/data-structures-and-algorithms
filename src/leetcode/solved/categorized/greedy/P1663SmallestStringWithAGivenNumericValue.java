package leetcode.solved.categorized.greedy;

import java.util.Arrays;

class P1663SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {

        char[] res = new char[n];
        // Generate the initial string all 'a' string.
        // This will reduce k by n i.e. 1 deceremented for each 'a'
        Arrays.fill(res, 'a');
        k -= n;

        // Then, turn rightmost 'a' into 'z' ('a' + 25, or 'a' + k) while k is positive.
        while (k > 0) {
            res[--n] = (char) ('a' + Math.min(25, k));
            k -= Math.min(25, k);
        }

        return String.valueOf(res);
    }

}