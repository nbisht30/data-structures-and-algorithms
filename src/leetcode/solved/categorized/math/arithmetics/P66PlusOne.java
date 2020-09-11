package leetcode.solved.categorized.math.arithmetics;

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
}
