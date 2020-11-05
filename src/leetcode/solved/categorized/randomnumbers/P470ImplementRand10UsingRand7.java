package leetcode.solved.categorized.randomnumbers;

import java.util.Random;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */
public class P470ImplementRand10UsingRand7 extends SolBase {
    public int rand10() {
        while (true) {
            int row = (rand7() - 1) * 7; // generates products of 7 from 0 to 42 i.e
            // 0, 7, 14, 21, 28, 35, 42 uniformly.
            int col = rand7(); // generating numbers from 1 to 7 uniformly
            int curr = row + col; // curr is a uniform random number from 1 to 49
            if (curr <= 40) // we need to ignore numbers b/w 41 - 49 because they dont have 0 and increase
                // the probability of numbers from 1 - 9 appearing little more than 0
                return (curr % 10) + 1; // return uniform random number from 1 to 10
            // else keep generating
        }
    }
}

class SolBase {
    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}

