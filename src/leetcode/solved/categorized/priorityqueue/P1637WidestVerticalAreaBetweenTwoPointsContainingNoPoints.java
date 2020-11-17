package leetcode.solved.categorized.priorityqueue;

import java.util.*;

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

    // Using sorting
    public int maxWidthOfVerticalAreaUsingSorting(int[][] points) {
        Comparator<int[]> comp = (a, b) -> a[0] - b[0];
        Arrays.sort(points, comp);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0] - points[i - 1][0];
            if (x > max) max = x;
        }
        return max;
    }
}