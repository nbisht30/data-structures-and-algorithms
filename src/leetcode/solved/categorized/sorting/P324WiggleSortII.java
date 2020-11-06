package leetcode.solved.categorized.sorting;

import java.util.Arrays;

class P324WiggleSortII {

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int i : nums) System.out.print(i + " ");
    }

    // @TODO : Understand the O(n) in-place solution that uses Quick Select to find median.
    public static void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int right = copy.length - 1;
        int left = ((copy.length + 1) / 2) - 1; // median

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[left--];
            } else {
                nums[i] = copy[right--];
            }
        }
    }
}