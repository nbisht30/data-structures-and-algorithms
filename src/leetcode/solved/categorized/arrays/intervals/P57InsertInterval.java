package leetcode.solved.categorized.arrays.intervals;

import java.util.ArrayList;
import java.util.List;

class P57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalRes = new ArrayList<>();
        if (intervals.length == 0) {
            intervalRes.add(newInterval);
        }
        int newSt = newInterval[0];
        int newEnd = newInterval[1];
        boolean intervalAdded = false;
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newSt || (intervals[i][1] == Integer.MAX_VALUE && newSt == Integer.MAX_VALUE)) {
                intervalRes.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            } else if (!intervalAdded) {
                newSt = Math.min(intervals[i][0], newSt);
                while (i < intervals.length && intervals[i][1] < newEnd) {
                    i++;
                }
                if (i < intervals.length && intervals[i][0] <= newEnd) {
                    newEnd = intervals[i][1];
                    i++;
                }
                intervalRes.add(new int[]{newSt, newEnd});
                intervalAdded = true;
                newSt = Integer.MAX_VALUE;
            } else {
                i++;
            }
        }
        if (intervalRes.get(intervalRes.size() - 1)[1] < newInterval[0])
            intervalRes.add(new int[]{newInterval[0], newInterval[1]});
        return intervalRes.toArray(new int[intervalRes.size()][]);
    }
}