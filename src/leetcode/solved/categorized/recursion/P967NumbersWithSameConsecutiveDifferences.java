package leetcode.solved.categorized.recursion;

import java.util.ArrayList;
import java.util.List;

class P967NumbersWithSameConsecutiveDifferences {
    // NEEDED HELP, TODO AGAIN
    // Time: A lot! (More than 2 hrs in total)
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