package leetcode.solved.categorized.math.randomnumbers;

import java.util.Random;

class P384ShuffleAnArray {

    int[] original;
    int[] current;

    public P384ShuffleAnArray(int[] nums) {
        original = nums;
        current = new int[nums.length];
        for (int i = 0; i < original.length; i++) {
            current[i] = original[i];
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        for (int i = 0; i < original.length; i++) {
            current[i] = original[i];
        }
        return current;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // Start from the end, Swap the i-th value with any value from index 0 to i and then fix the ith element
        Random rand = new Random();
        for (int i = current.length - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(current, i, j);
        }
        return current;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */