package leetcode.solved.categorized.arrays;

class P1395CountNumberOfTeams {
    // Myself
    // Date: 24-Nov
    // Time: ~ 18 mins for AC(although in first attempt)
    // Improvements: Took a lot of time(12 - 15 mins) trying to think of an optimized solution, then ended up coding the O(n^3) cubic solution
    // which got accepted. Need to analyze what is the expected time complexity based on the constraints.

    // @TODO: learn the N^2 and then the DP solution

    public int numTeams(int[] rating) {
        int N = rating.length;
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(rating[j] > rating[i]){
                    for(int k = j + 1; k < N; k++){
                        if(rating[k] > rating[j]){
                            count++;
                        }
                    }    
                } else if (rating[j] < rating[i]) {
                    for(int k = j + 1; k < N; k++){
                        if(rating[k] < rating[j]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
}