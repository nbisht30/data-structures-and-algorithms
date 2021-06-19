package leetcode.categorized.arrays.missingnumbers;

import java.util.HashSet;
import java.util.Set;

class P41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        return optimizedVersion(nums);
    }

    public int optimizedVersion(int[] nums) { // O(n) time and O(1) space.

        // Pass 1: Check the whole array and if 1 is missing return 1.(smallest positive number)
        boolean hasOne = false;
        for (int i : nums)
            if (i == 1) {
                hasOne = true;
                break;
            }
        if (!hasOne) return 1;

        // Pass 2: Wherever a 0, -ve number or number greater than length of array is found make it = 1
        // Basically, we're invalidating these numbers as 0 and -ve are not positive and a number bigger than length of array is already very large.
        // Also, since we've already checked for 1 earlier, we can use 1 as a placeholder now.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }

        // Pass 3: Invalidate the indices corresponding to all numbers > 0 present in the array.
        for (int i : nums) {
            int ind = Math.abs(i); // Get element abs value as an index.
            if (ind < nums.length) {
                nums[ind] = -1 * Math.abs(nums[ind]); // Go the that index and invalidate the value already present there by negating. 
                // We need to use Math.abs(nums[ind]) as if there is any number is present more than once in the array,
                // we would negate its index once when we find it for the first time.When that number is found again, the value at index would be already negative 
                // due to negation that happend earlier and we dont want to make it positive by multiplying with -1.
            } else {
                nums[0] = -1 * Math.abs(nums[0]); // If we find a number in the array = the length of the array we invalidate the 0th index.
                // If sync a number is not found then 0th will always be positive as we invalidated all 0 values in Pass 2 by storing 1.
            }
        }

        // Pass 4: Loop through the array and return the first index at which value is positive. Starting from 1.
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }

        if (nums[0] > 0)
            return nums.length; // If you didnt returning anything in Pass 4 check if you have positive at 0th index
        // meaning that nums.length was the only smallest positive number not found in the array.

        return i + 1; // Only for case when 1 is the only element in the array.
    }

    public int bruteForceUsingSet(int[] nums) {
        int smPos = 1;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) if (i > 0) set.add(i);

        for (int i : nums) if (set.contains(smPos)) smPos++;

        return smPos;
    }
}