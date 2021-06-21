package leetcode.categorized.math.time;

class P1904TheNumberOfFullRoundsYouHavePlayed {
    // @TODO: Revisit
    // NEEDED HELP
    // EXPLANATION: https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/discuss/1284240/C%2B%2B-straightforward-3-lines
    public int numberOfRounds(String startTime, String finishTime) {
        int minsTillStart = getMinutes(startTime);
        int minsTillFinish = getMinutes(finishTime);

        // If minsTillStart are more than minsTillFinish
        // => we played overnight, so we add no. of minutes in 24 hrs i.e. 24 * 60 to minsTillFinish
        if (minsTillStart > minsTillFinish) minsTillFinish += 24 * 60;

        // Divide minsTillStart and minsTillFinish by 15, and round them UP and DOWN respectively.
        // We need to round the minsTillStart and minsTillFinish to their next and previous closest 15-minute rounds, respectively.

        int roundsTillStart = (minsTillStart + 14) / 15; // for rounding up to next 15-min round we're adding 14
        int roundsTillFinish = minsTillFinish / 15;
        int netRounds = roundsTillFinish - roundsTillStart;

        // Return max of 0 and netRounds as netRounds can be negative for cases when minsTillStart > 0 and roundsTillFinish < 15
        // eg. if startTime = "00:01" and finishTime = "00:02" then roundsTillStart = 1 + 14 / 15 = 1 and
        // roundsTillFinish = 2 / 15 = 0, so netRounds will be negative.
        return Math.max(0, netRounds);
    }


    // Get total minutes from "00:00" to time
    int getMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int extraMins = Integer.parseInt(time.substring(3, 5));
        int totalMins = hours * 60 + extraMins;
        return totalMins;
    }
}