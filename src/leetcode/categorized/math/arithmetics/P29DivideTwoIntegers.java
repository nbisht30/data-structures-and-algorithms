package leetcode.categorized.math.arithmetics;

class P29DivideTwoIntegers {
    // My solution : https://leetcode.com/problems/divide-two-integers/discuss/924383/java-purely-without-and-long-data-type-explained
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // Case: Result out of range

        // Case: When divisor is 1 or -1, i.e. no division is needed
        if (divisor == 1) return dividend;
        if (divisor == -1)
            return -dividend; // In case dividend is Integer.MIN_VALUE, and there's an overflow, we've already handled it above

        // If divisor is Integer.MIN_VALUE we can return 1 if dividend is also Integer.MIN_VALUE
        // otherwise 0 because every other integer would be smaller than 2147483648 and dividing by -2147483648 would give us 0.
        if (divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE ? 1 : 0;

        boolean isNeg = (dividend > 0) ^ (divisor > 0); // To check if just one is negative.

        // Now we still have a case if dividend is out of range, and we convert it to positive, it would cause overflow, so we add a 1 and maintain a flag
        // which can be used later.
        boolean dividendOutOfRange = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend += 1;
            dividendOutOfRange = true;
        }

        // Convert both to positive for easy subtraction
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Calculate the quotient
        int quo = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            quo++;
        }

        // Check if dividend was out of range and if adding a 1 gives us a number = divisor, so we can divide one more time and increase the quotient
        if (dividendOutOfRange && ((dividend + 1) == divisor)) {
            quo++;
        }

        return isNeg ? -quo : quo;
    }
}