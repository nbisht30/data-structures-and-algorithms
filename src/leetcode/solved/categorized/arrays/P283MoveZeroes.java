package leetcode.solved.categorized.arrays;

/**
 * @author Nikhil Bisht
 * @date 04-04-2020
 */
public class P283MoveZeroes {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]  != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
