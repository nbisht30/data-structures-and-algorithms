package leetcode.solved.categorized.priorityqueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class P1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] arr : points) set.add(arr[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int a : set) {
            heap.add(a);
        }
        int prev = heap.poll(), curr;
        int max = 0;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            if (curr - prev > max) max = curr - prev;
            prev = curr;
        }
        return max;
    }
}