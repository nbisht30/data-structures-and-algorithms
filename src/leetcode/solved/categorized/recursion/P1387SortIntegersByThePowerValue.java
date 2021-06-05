package leetcode.solved.categorized.recursion;

import java.util.Arrays;
import java.util.Comparator;

class P1387SortIntegersByThePowerValue {
    // MYSELF
    // DATE: 04-06-2021, first attempt
    // TIME: 16 mins
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] numWithPwr = new int[n][2];

        for (int i = lo; i <= hi; i++) {
            numWithPwr[i - lo][0] = i;
            numWithPwr[i - lo][1] = findPower(i, 0);
        }

        Arrays.sort(numWithPwr, Comparator.comparingInt(a -> a[1]));
        return numWithPwr[k - 1][0];
    }

    int findPower(int x, int steps) {
        if (x == 1) return steps;
        steps++;
        if (x % 2 == 0) return findPower(x / 2, steps);
        else return findPower(x * 3 + 1, steps);
    }
}