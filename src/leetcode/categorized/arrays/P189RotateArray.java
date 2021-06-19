package leetcode.categorized.arrays;

class P189RotateArray {

    /*
    Method 1: Time: O(n), Space: O(n)
    Take an extra array.
    Traverse nums from nums.length - k and put elements to new array.
    Again traverse nums from 0 to nums.length - k - 1 and put elements to extra array.

    Method 2: Time: O(n * k), Space: O(1)
    Shift elements by 1 to the right in one iteration, when you reach
    the last element store it in temp before shifting and after shifting, put temp in
    nums[0];
    Have total k iterations(IMP: Mod k by n in case the number k is very large
    as if we rotate an array n number of times we just get the original array)

    Method 3: Use array reversals
    First do k = k % nums.length
    Reverse the whole array from 0 to nums.length - 1.
    Reverse from 0 to k - 1.
    Reverse from k to nums.length - 1.
    */

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int st, int end) {
        for (int i = st, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}