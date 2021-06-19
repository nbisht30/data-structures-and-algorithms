package leetcode.categorized.math.arithmetics;

class P66PlusOne {
    // MYSELF
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int lastInd = digits.length - 1;
        digits[lastInd]++;
        for (int i = lastInd; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] == 10) {
                carry = 1;
                digits[i] = 0;
            } else break;
        }
        if (digits[0] == 0 || digits[0] == 10) {
            int res[] = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    // MYSELF
    // TIME: 30 mins
    // DATE: 10-May-2021
    // COMMENTS: Shortened the code.
    public int[] plusOneSecondAttempt(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            digits[i] += 1;
            if(digits[i] == 10) digits[i] = 0;
            else return digits;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
