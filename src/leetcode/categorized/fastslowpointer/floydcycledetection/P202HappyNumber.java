package leetcode.categorized.fastslowpointer.floydcycledetection;

import java.util.HashSet;
import java.util.Set;

public class P202HappyNumber {

    // 1. Using Hashing(Sets)
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

    // 2. Using Recursion
    public boolean isHappyRecursive(int n) { //recursive: faster than above soln
        if (n == 1 || n == 7)
            return true;
        if (n < 10)
            return false;
        return isHappyRecursive(squareSumDigits(n));
    }

    // 3. Using Fast and Slow Pointers.
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
