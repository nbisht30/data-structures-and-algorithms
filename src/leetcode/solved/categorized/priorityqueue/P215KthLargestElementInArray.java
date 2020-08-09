package leetcode.solved.categorized.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class P215KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return usingArraySort(nums, k);
    }

    public int usingArraySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }

    public int usingHeaps(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pQ.add(i);
        }

        for (int i = 1; i <= k; i++) {
            pQ.remove();
        }

        return pQ.remove();
    }
}