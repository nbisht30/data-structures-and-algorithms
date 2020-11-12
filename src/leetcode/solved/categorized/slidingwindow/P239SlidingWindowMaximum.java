package leetcode.solved.categorized.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        Algo:-
        1. Check if inputs are valid or not
        2. Declare a result array and dequeue.
        3. Iterate over the array
        4. First remove those indices from the front of dequeue which are out of bounds of the current window
        5. Then you're left with only those elements that are in the scope of current window.
        6. Now remove those elements from the last of dequeue which are smaller than current element, so that
        you're just tracking index of the max element till current value of i.
        7. Then add the current maximum at the end.
        8. Now, check if at least first window has been iterated, and add the first into the result.
        */
        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> indexDq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!indexDq.isEmpty() && indexDq.peekFirst() == i - k) indexDq.pollFirst();

            while (!indexDq.isEmpty() && nums[indexDq.peekLast()] < nums[i]) indexDq.pollLast();

            indexDq.offerLast(i);

            if (i >= k - 1) {// check for first window
                res[i - k + 1] = nums[indexDq.peekFirst()];
            }
        }


        return res;
    }
}