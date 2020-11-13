package leetcode.solved.categorized.arrays.intervals;

import java.util.Arrays;
// @TODO: DO THIS AGAIN!!!!
// https://leetcode.com/problems/non-overlapping-intervals/
class P435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort array by increasing order of end, and if values at end are equal for two intervals,
        // interval with larger start comes first. Sorting using a custom comparator
        // Note: If Comparator for any two values a and b returns -ve value then a has more priority than b,
        // or a comes first in result after sorting. 0 means equal priority and +ve means a comes after b.
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        
        /*
        Why can't we sort by starting point of intervals?
        
        Because if there is an interval that spans several non-overlapping intervals, but having a starting point
        less than all of them, then that interval would be placed before them, and lead to removal of all those non
        overlapping intervals.
        */

        int minErase = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) minErase++; // If end of previous interval
                // is greater than start of current interval, then an overlap has been found.
            else prevEnd = intervals[i][1];
        }

        return minErase;
    }
}