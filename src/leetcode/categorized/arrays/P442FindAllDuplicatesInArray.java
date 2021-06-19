package leetcode.categorized.arrays;

import java.util.ArrayList;
import java.util.List;

class P442FindAllDuplicatesInArray {

    // My solution: Uses O(n) extra space.
    public List<Integer> findDuplicates(int[] nums) {
        int count[] = new int[nums.length + 1];
        List<Integer> retList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                retList.add(i);
            }
        }
        return retList;
    }

    public List<Integer> findDuplicatesUsingNegation(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // Iterate through the numbers, since the numbers are between 1 and n, jump to the number's index and make the number negative
        for (int i = 0; i < nums.length; i++) {
            // The number may be negative, while taking the index take its absolute for positive index(index cannot be negative)
            int j = Math.abs(nums[i]);
            // Check if the number is negative, if it is negative it has been occured before and is a duplicate number
            // The numbers are from 1 to n, but indices are from 0 to n-1, so to jump to its index we need to subtract 1
            if (nums[j - 1] < 0)
                res.add(j);
            else
                // Otherwise, this is the first occurence of the number and we multiply it by -1 to make it negative
                nums[j - 1] *= -1;
        }
        return res;
    }

}