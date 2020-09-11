package leetcode.solved.categorized.math.arithmetics;

class P66PlusOne {
    // MYSELF
    public int[] plusOne(int[] digits) {
        if(digits.length == 1) {
            if(digits[0] == 9) return new int[]{1,0};
            else {
                digits[0]++;
                return digits;
            }
        }
        int carry = 0, n;
        int lastInd = digits.length - 1;
        digits[lastInd]++;
        for(int i = lastInd; i >= 0; i--){
            digits[i] += carry;
            if(digits[i] / 10 == 1) {
                carry = 1;
                digits[i] %= 10;
            }
            else return digits;
        }
        if(digits[0] == 0){
            int res[] = new int[digits.length + 1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++) res[i + 1] = digits[i];
            return res;
        }
        return digits;
    }
}