package leetcode.contests.weekly;

class P1551MinimumOperationsToMakeArrayEqual {
    // MYSLEF
    // DATE: 17-05-21, second attempt
    // TIME: 8 mins
    // COMMENTS: Cleaned the existing approach
    // TODO: Bitwise operator approach
    public int minOperations(int n) {
        int mid = n / 2;
        int opns = 0;
        int num = 2 * mid + 1;
        if (n % 2 == 0) {
            num -= 1;
            mid--;
            opns++;
        }
        for (int i = 0; i < mid; i++) {
            opns += num - (2 * i + 1);
        }
        return opns;
    }
}
