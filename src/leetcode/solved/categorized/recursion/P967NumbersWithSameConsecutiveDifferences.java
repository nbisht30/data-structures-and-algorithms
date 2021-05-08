package leetcode.solved.categorized.recursion;

import java.util.ArrayList;
import java.util.List;

class P967NumbersWithSameConsecutiveDifferences {
    // NEEDED HELP, CODED AFTER GETTING THE IDEA, TODO AGAIN
    // TIME: A lot! (More than 2 hrs in total)

    /*
    Approach: Recursion or DFS approach.
    Intuition: If N == 1 then you just return all numbers from 0 to 9 otherwise.
    You need to consider any combination only when the digit your'e going to add has a
    difference of k with the digit already present on the left, otherwise you dont consider that combination.
     */
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<Integer>();
        if (N == 1) list.add(0);
        for (int i = 1; i <= 9; i++) {
            helper(N, K, list, i, 0);
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }

    public void helper(int n, int k, List<Integer> list, int curDig, int num) {
        num *= 10;
        num += curDig;
        n--;

        if (n == 0) {
            list.add(num);
            return;
        }

        if (k == 0) helper(n, k, list, curDig, num);
        else {
            if (k != 0 && curDig + k <= 9) {
                helper(n, k, list, curDig + k, num);
            }

            if (k != 0 && curDig - k >= 0) {
                helper(n, k, list, curDig - k, num);
            }
        }
    }
}