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

    public static boolean happyNumberMyAttempt(int n) {
        Set<Integer> checkedFor = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            } else if (checkedFor.contains(n)) {
                return false;
            }
            checkedFor.add(n);
            n = sumOfSquaresOfDigits(n);
        }
    }

    private static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += ((n % 10) * (n % 10));
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappyRecursive(int n) { //recursive: faster than above soln
        if (n == 1 || n == 7)
            return true;
        if (n < 10)
            return false;
        return isHappyRecursive(sumOfSquaresOfDigits(n));
    }

    public static boolean isHappyFloydsCycleDetection(int n) { //The concept of fast and slow pointer.
        int slow, fast;
        slow = fast = n;
        do {
            slow = sumOfSquaresOfDigits(slow);
            fast = sumOfSquaresOfDigits(fast);
            fast = sumOfSquaresOfDigits(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        else return false;
    }


}
