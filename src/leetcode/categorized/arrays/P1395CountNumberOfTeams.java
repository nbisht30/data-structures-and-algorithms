package leetcode.categorized.arrays;

class P1395CountNumberOfTeams {
    // MYSELF
    // DATE: 24-Nov-20
    // TIME: ~ 18 mins for AC(although in first attempt)
    // Improvements: Took a lot of time(12 - 15 mins) trying to think of an optimized solution, then ended up coding the O(n^3) cubic solution
    // which got accepted. Need to analyze what is the expected time complexity based on the constraints.

    // @TODO: learn the N^2 and then the DP solution

    public int numTeams(int[] rating) {
        int N = rating.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (rating[j] > rating[i]) {
                    for (int k = j + 1; k < N; k++) {
                        if (rating[k] > rating[j]) {
                            count++;
                        }
                    }
                } else if (rating[j] < rating[i]) {
                    for (int k = j + 1; k < N; k++) {
                        if (rating[k] < rating[j]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // @TODO: Revisit
    // NEEDED HELP
    // DATE: 23-May-21, second attempt
    // COMMENTS: Coded the brute force but it did not get accepted this time.
    /* ALGORITHM O(N*N):-
       For each soldier, count the number of soldiers with lesser ratings on the left(lessLeft) and greater ratings on the right(greaterRight).
       and count the number of soldiers with greater ratings on the left(greaterLeft) and lesser ratings on the right(lessRight);
       then number of teams using that soldier is = lessLeft * greaterRight + greaterLeft * lessRight;
     */
    public static int numTeamsOptimized(int[] rating) {
        int numTeams = 0;
        for (int mainSoldier = 1; mainSoldier < rating.length - 1; mainSoldier++) {

            int lessLeft = 0, lessRight = 0, greaterLeft = 0, greaterRight = 0;

            for (int currSoldier = 0; currSoldier < rating.length; currSoldier++) {
                if (rating[currSoldier] > rating[mainSoldier]) {
                    if (currSoldier < mainSoldier) greaterLeft++;
                    else greaterRight++;
                } else if (rating[currSoldier] < rating[mainSoldier]) {
                    if (currSoldier < mainSoldier) lessLeft++;
                    else lessRight++;
                }
            }
            numTeams += lessLeft * greaterRight + greaterLeft * lessRight;
        }
        return numTeams;
    }
}