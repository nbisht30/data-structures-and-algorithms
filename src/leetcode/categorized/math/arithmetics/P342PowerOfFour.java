package leetcode.categorized.math.arithmetics;

/*
EXPLANATION: If a number(x) is a power of 4 then it needs to satisfy below three properties.
1. Be greater than zero i.e. x > 0

2. Be a power of 2 i.e there is only one bit set in the binary representation of x.
We can check this using x & (x-1) which deletes the lowest '1' bit, and if result becomes 0, it proves that there is only one '1' bit.
For example: 16 (10000) is power of 2 because there is only one bit set.
x & (x - 1) for 16 => 16 & 15 => 10000 & 01111 => 0

3. The only '1' bit should be present at the odd location i.e count of 0s on the right of 1 should be odd.
To check if '1' is in odd place, we can to bitwise AND(&) of x with '0xAAAAAAAA' and check if result is equal to zero.
Note: '0xAAAAAAAA' is a hexadecimal number，it is 0101010101010101010101010101010 in binary with a length of 32. To make sure the 1 locates in the even location.
 */
public class P342PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xAAAAAAAA) == 0);
    }
}
