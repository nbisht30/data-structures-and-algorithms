package leetcode.thirtydaychallengeapril;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */
// https://leetcode.com/problems/product-of-array-except-self/

public class Day15ProdOfArrayExceptSelf {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public static int[] productExceptSelf(int[] nums) {
        int prod[] = new int[nums.length];
        prod[0] = nums[0];
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            prod[i] = nums[i] * prod[i - 1];
        }
        int prodRight = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prodRight *= nums[i];
            if (i == nums.length - 1) {
                nums[i] = prod[i - 1];
            } else {
                nums[i] = prod[i - 1] * prodRight;
            }
        }
        return nums;
    }
}
