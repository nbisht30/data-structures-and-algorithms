package leetcode.categorized.bitmanipulation;

public class P191NumberOf1Bits {
    /*
    Some backstory:-
    
    Signed Data Types - In Java, int data type is a signed data type, which means it can store both negative and 
    positive numbers. The first bit(least significant bit) is used to store the value for sign. Due to one bit 
    being used to store the sign, such signed data types cannot store large unsigned numbers.
    
    Unsigned Data Types - In languages like C and C++ there are data types that only store unsigned(i.e 
    positive) numbers. This allows them to store larger numbers. In Java, there is no such unsigned data type.
    */


    // In this question n is passed as an unsigned value
    public int hammingWeight(int n) {
        
        
        /* 
        >>> (Unsigned right shift) : In Java, the operator ‘>>>’ is unsigned right shift operator, i.e. it appends a zero to the left most position.
        irrespective of the sign of the number.
         */

        int c = 0;
        while (n != 0) {
            c += n & 1; // Counts the last bit if it is 1, n & 1 returns 1 if last bit is one
            n = n >>> 1; // Eventually only 0 would be left.
        }
        return c;
    }
}