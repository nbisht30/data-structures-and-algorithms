package leetcode.solved.categorized.bitmanipulation;

import static java.lang.System.out;

// https://leetcode.com/problems/reverse-bits/
public class P190ReverseBits {
    // EXPLANATION: https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
    // NEEDED HELP, figured out that we need to find last bit using n & 1 and shift n to left by 1 in each iteration
    // but could not understand how to change the value of res in each interation
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            int lastBit = n & 1;
            res = res | lastBit;
            n = n >> 1;
        }
        out.println();
        return res;

    }
}