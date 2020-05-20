package leetcode.thirtydaychallengemay;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
class Day12_P540SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];

        return helperRec(nums, 0, nums.length - 1);
    }

    private int helperRec(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;

        if (lo == mid || hi == mid) {
            return nums[mid];
        }

        int lenLeft = 0;

        if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
            return nums[mid];
        else if (nums[mid] == nums[mid + 1]) {
            lenLeft = mid - lo;
            if (lenLeft % 2 != 0) {
                hi = mid - 1;
            } else {
                lo = mid + 2;
            }
        } else {
            lenLeft = mid - 1 - lo;
            if (lenLeft % 2 != 0) {
                hi = mid - 2;
            } else {
                lo = mid + 1;
            }
        }
        return helperRec(nums, lo, hi);
    }
}