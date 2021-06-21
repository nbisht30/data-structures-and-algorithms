package leetcode.categorized.math.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class P539MinimumTimeDifference {
    // MYSELF
    // COMMENT: Could solve this after solving P1904
    // TIME: 30 mins
    // INTUITION: Slightly less optimized, a faster version exists that uses bucket sort.
    /*
    1. For each timePoint, find the minutes(mins) from "00:00" to timePoint
    2. Put these minutes in a different list, and then sort the list and check for differences b/w each minute equivalent.
    Also if mins < minsTwelveHr, then also add same time for next day in the list as that might give you lesser difference, eg if
    input = ["23:59","00:00"] and you dont put next day's time,
    then for "00:00" you'll put 0 mins and for "23:59" you'll put 23 * 60 + 59 mins in the list
    now if you check for min difference, you're going to get 23 * 60 + 59 - 0, 
    while the answer should be 1 since from 23:59 you need only 1 min to get to 00:00, hence when adding 00:00
    you should also add 24 * 60 + 0 (mins for 24 hrs + mins for 00:00) to the list, 
    so that when you check for min diff you also consider, 24 * 60 - (23 * 60 + 59) = 1. 
    Point being, 00:00 can be considered as time for this day and 00:00 could also be time for the next day
    */
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<>(timePoints.size() * 2);
        int minsTwelveHr = 12 * 60;
        for (int i = 0; i < timePoints.size(); i++) {
            int mins = toMinutes(timePoints.get(i));
            list.add(mins);
            if (mins < minsTwelveHr) list.add(mins + 24 * 60); // add one day as well.
        }
        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
            if (minDiff == 0) return 0;
        }

        return minDiff;
    }

    int toMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int mins = Integer.parseInt(time.substring(3, 5));
        return hours * 60 + mins;
    }
}