package leetcode.thirtydaychallengeapril;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nikhil Bisht
 * @date 02-04-2020
 */
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
public class Day2HappyNumber {
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
