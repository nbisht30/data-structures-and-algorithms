package leetcode.solved.categorized.priorityqueue;

import java.util.*;

class P1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    // MYSELF
    // DATE: 15-May-2021, second attempt.
    // TIME: 10 Mins
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int maxDiff = 0;
        for(int i = 1; i < points.length; i++) {
            maxDiff = Math.max(maxDiff, points[i][0] - points[i - 1][0]);
        }
        return maxDiff;
    }
}