package leetcode.contests.weekly;

class P1551MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        if (n % 2 == 1) {
            int mid = n / 2;
            int valMid = (mid * 2) + 1;
            int i = 0;
            int opn = 0;
            while (i < mid) {
                opn += (valMid - ((2 * i) + 1));
                i++;
            }
            return opn;
        } else {
            int mid = (n / 2) - 1;
            int valMid = ((mid * 2) + 1) + 1;
            int opn = 1;
            int i = 0;
            while (i < mid) {
                opn += (valMid - ((2 * i) + 1));
                i++;
            }
            return opn;
        }
    }
}