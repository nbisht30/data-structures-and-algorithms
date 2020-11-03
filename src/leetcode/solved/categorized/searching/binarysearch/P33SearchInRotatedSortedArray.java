package leetcode.solved.categorized.searching.binarysearch;

import java.util.Arrays;

/**
 * @author Nikhil Bisht
 * @date 07-05-2020
 */
public class P33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 8, 10, 1, 2};
        System.out.println(search(arr, 2));
    }

    public static int search(int[] nums, int target) {
        int rotationPoint = 0;
        if (nums.length == 0) return -1;
        if (nums[0] < nums[nums.length - 1]) { //unrotated fully sorted in ascending order from 0 to last index
            int ind = Arrays.binarySearch(nums, target);
            return ind < 0 ? -1 : ind;
        }
        rotationPoint = getRotationPoint(nums, 0, nums.length - 1);
        int leftArray = Arrays.binarySearch(nums, 0, rotationPoint + 1, target);
        int rightArray = Arrays.binarySearch(nums, rotationPoint + 1, nums.length, target);
        if (leftArray <= -1 && rightArray >= 0) return rightArray;
        if (leftArray >= 0 && rightArray <= -1) return leftArray;
        return -1;
    }

    private static int getRotationPoint(int[] nums, int st, int end) { //point after which array starts in increasing order
        int mid = (st + end) / 2;
        if (mid == st || mid == end) return mid;
        if (nums[st] > nums[mid]) {//rotationPoint present at left of mid
            return getRotationPoint(nums, st, mid);
        }
        if (nums[mid] > nums[end]) { //rotationPoint present at right of mid
            return getRotationPoint(nums, mid, end);
        }
        return end;
    }
}