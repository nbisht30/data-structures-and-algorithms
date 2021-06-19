package leetcode.categorized.arrays.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1);

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] merged = list.get(j);
            if (merged[1] >= curr[0]) {
                merged[1] = Math.max(merged[1], curr[1]);
            } else {
                list.add(curr);
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}