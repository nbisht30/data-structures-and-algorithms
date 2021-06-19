package leetcode.categorized.stack;

import java.util.Stack;

class P84LargestRectangleInHistogram {
    /*
    This is O(n) solution, even though it looks like an O(N^2) solution.
    EXPLANATION: https://www.youtube.com/watch?v=t8p5FS6flw8&ab_channel=PrakashShukla
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        // Finding the width
        int size = heights.length;
        // left boundary: index of element smaller than i-th element on the left side
        int[] left = new int[size];
        // right boundary: index of element smaller than i-th element on the right side
        int[] right = new int[size];
        Stack<Integer> stack = new Stack<>();
        // Finding left[]

        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.add(i);
        }
        // Finding right[]
        stack.clear();
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

            if (stack.isEmpty()) {
                right[i] = size;
            } else {
                right[i] = stack.peek();
            }

            stack.add(i);
        }

        // Finding max
        int max = 0, currWidth = 0;
        for (int i = 0; i < size; i++) {
            currWidth = right[i] - left[i] - 1;
            max = Math.max(max, currWidth * heights[i]);
        }

        return max;
    }

    // EXPLANATION: https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    public int largestRectangleAreaDP(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        int size = heights.length;

        // Array to track smaller element's index on the left of i
        int[] left = new int[size];
        left[0] = -1; // 0th element does not have anything to the left
        for(int i = 1; i < size; i++){
            int itr = i - 1;
            while(itr >= 0 && heights[itr] >= heights[i]) itr = left[itr];
            left[i] = itr;
        }
        // Array to track smaller element's index on the right of i
        int[] right = new int[size];
        right[size - 1] = size; // last element does not have anything to the right
        for(int i = size - 2; i >= 0; i--){
            int itr = i + 1;
            while(itr <= size - 1 && heights[itr] >= heights[i]) itr = right[itr];
            right[i] = itr;
        }

        // Calculating max:-
        int max = 0;
        for(int i = 0; i < size; i++) max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);

        return max;
    }
}