package leetcode.categorized.arrays.twopointers;

class P27RemoveElement {
    // MYSELF
    // DATE: 18-10-23, first attempt
    // TIME: 15 mins
    // APPROACH : Two Pointers
    /* INTUITION:
        Use two pointers, one for tracking elements from the left of the array, one for tracking elements from the right
        of the array. Swap the elements, whenever you see a number == val on the left pointer and a number != val on the
        right pointer, because we have to bring the elements != val on the left side of the array.
     */
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if(nums[left] != val) {
                left++;
            } else if(nums[right] == val) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}