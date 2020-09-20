package leetcode.solved.categorized.bitmanipulation;

/*
Problem: https://leetcode.com/problems/sum-of-two-integers/
Explanation: https://www.youtube.com/watch?v=aIhRj_4PMYQ&ab_channel=SDESkills
 */
class P371SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int carry = a & b; // Find the carry, but this gives us the value of carry at (i - 1)-th position
        a = a ^ b; // Add a and b using XOR(carry not considered)
        b = carry << 1; //  So, left shift the carry to get it at i-th positon
        if(b == 0) return a; // If your carry was zero, then return the addition value done without carry in line : a = a ^ b
        else return getSum(a, b); // Repeat otherwise;
    }
}