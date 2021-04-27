package leetcode.solved.categorized.fastslowpointer.floydcycledetection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nikhil Bisht
 * @date 02-04-2020
 */
/*
This can be solved in multiple ways.
1. Using Hashing(Sets)
2. Using Recursion
3. Using Fast and Slow Pointers.
* */
public class P202HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyFloydsCycleDetection(85));
    }

    // Using sets
    public boolean isHappy(int n) {
        Set<Integer> cycle = new HashSet<>();
        while (!cycle.contains(n)) {
            cycle.add(n);
            n = squareSumDigits(n);
            if (n == 1) return true;
        }
        return false;
    }

    public static int squareSumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyRecursive(int n) { //recursive: faster than above soln
        if (n == 1 || n == 7)
            return true;
        if (n < 10)
            return false;
        return isHappyRecursive(squareSumDigits(n));
    }

    public static boolean isHappyFloydsCycleDetection(int n) { //The concept of fast and slow pointer.
        int slow, fast;
        slow = fast = n;
        do {
            slow = squareSumDigits(slow);
            fast = squareSumDigits(fast);
            fast = squareSumDigits(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        else return false;
    }


}
