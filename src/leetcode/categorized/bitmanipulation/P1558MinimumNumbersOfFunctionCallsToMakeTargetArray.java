package leetcode.categorized.bitmanipulation;

class P1558MinimumNumbersOfFunctionCallsToMakeTargetArray {
    // https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/discuss/805672/Simple-Explanation
    /*
    Minimum number of operations = Total number of +1 operations for each number
    + Number of x2 operations for the max number among all numbers
    (because all numbers could be x2 in one combined operation, so we just count the x2 required for the max num)

    Number of +1 operations for any number = Number of 1s in the binary representation of each number,
        because each 1 in binary representation is introduced by a +1 operation.

    Number of x2 operations = Position of leftmost set bit(excluding Most Significant Bit used for representing sign, hence the condition < 31 in loop)
    in binary representation among all numbers, because each x2 operation shifts the binary digit to left.

    Eg.You can make 37 by the following steps Starting from 0:-
    0 + 1 = 1
    1 x 2 = 10
    10 x 2 = 100
    100 x 2 = 1000
    1000 + 1 = 1001
    1001 x 2 = 10010
    10010 x 2 = 100100
    100100 + 1 = 100101
    totalOpns = 8. If you had another number in the input array along with 37 but smaller than 37 then
    you'll just count the number of add operations for that number, add that to totalOpns i.e. 8 and return the answer.
    */
    public int minOperations(int[] nums) {
        int addOneOpns = 0, x2Opns = 0, leftMostSetBit = 0, numOfSetBits = 0;

        for (int bit = 0; bit < 31; bit++) {
            for (int num : nums) {
                boolean isSetBit = (num & (1 << bit)) != 0;
                if (isSetBit) {
                    numOfSetBits++;
                    leftMostSetBit = bit;
                }
            }
        }
        addOneOpns = numOfSetBits;
        x2Opns = leftMostSetBit;
        return addOneOpns + x2Opns;
    }
}
