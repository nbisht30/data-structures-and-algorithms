package leetcode.solved.categorized.priorityqueue;

import java.util.PriorityQueue;

class P556NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        int leftHalf = n;
        int prev = Integer.MIN_VALUE;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (leftHalf > 0) {
            int curr = leftHalf % 10;
            minHeap.add(curr);
            leftHalf /= 10;

            if (curr < prev) {
                int rightHalf = 0;
                int countChar = 0;

                while (minHeap.peek() <= curr) {
                    rightHalf = rightHalf * 10 + minHeap.poll();
                    countChar++;
                }

                int numInsert = minHeap.poll(); // next greatest element

                leftHalf = leftHalf * 10 + numInsert;
                for (int i = 0; i < countChar; i++) {
                    if (leftHalf > Integer.MAX_VALUE / 10) return -1;
                    leftHalf *= 10;
                }

                countChar = 0;
                while (!minHeap.isEmpty()) {
                    rightHalf = rightHalf * 10 + minHeap.poll();
                    countChar++;
                }

                for (int i = 0; i < countChar; i++) {
                    if (leftHalf > Integer.MAX_VALUE / 10) return -1;
                    leftHalf *= 10;
                }
                return (leftHalf + rightHalf) < 0 ? -1 : leftHalf + rightHalf;
            }
            prev = curr;
        }
        return -1;
    }
}