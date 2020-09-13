package leetcode.solved.categorized.math;

class P172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        /*
        If n = 5 then number of 0s in n! i.e. 1x2x3x4x5 is the number of 10s that can be
        generated by numbers from 1 to 5. 10 is a product of 2 and 5 so we just need to check
        how many 2x5 are present in n! There's is at least a 2 and only one 5 present in
        in 5! which can make one 10. So numbers of 0s in 5! is one.

        If n = 10, then n! = 1x2x3x4x5x6x7x8x9x10 => this would have two zeros one from the
        2x5 and one from another 2x5 in 10.

        If n = 15, then n! = 1x2x3x4x5x6x7x8x9x10x11x12x13x14x15 => this would have three
        zeros one from the 2x5 and one from another 2x5 in 10 and one from a 5 in 15 which
        would give us a 0 by multiplying with any 2 from any even num from 1 to 15.

        So we need to just get how many multiples of 10(i.e 2x5) are present in n!
        to get number of 0s. Since there are a lot more 2s than 5s we just need to find the
        number of 5 and that will be the answer.

        So, 5! -> one 0s
        10! -> number of 0s in 5! + 0s which can be generated from 6 to 10 -> two 0s
        15! -> number of 0s in 10!+ 0s which can be generated from 10 to 15 -> three 0s
        20! -> four 0s
        We can see that the number of zeros in n! is euqal to just n / 5.
        But there's a catch.
        For 25! -> number of 0s in 10! + number of 0s which can be generated from 21 to
        -> number of 0s in 10! + two 0s as there are two 5s present in 25 which would
        multiple with any two 2s and make a 100 and give us 2 zeros.
        -> so 25! has six 0s.

        But, going by the original formula we'll calculate number of 0s in 25! as
        25/5 which is 5. So five 0s. But what we need to do now is just divide this result
        of 5 again by 5 which gives us a 1 and add it to previous five 0s

        Intuition: Keep dividing by 5 and adding the result to number of 0s.
        */

        int numZeros = 0;
        while (n >= 5) {
            numZeros += n / 5;
            n = n / 5;
        }
        return numZeros;
    }
}