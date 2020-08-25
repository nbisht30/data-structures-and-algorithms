package leetcode.solved.categorized.dp;

class P983MinimumCostForTickets {
    //NEEDED HELP
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        return rec(days, costs, dp, 0);
    }
    
    public int rec(int[] days, int[] costs, int[] dp, int i){
        if(i >= days.length) return 0;
        if(dp[i] > 0) return dp[i];
        
        // Option 1
        int option1 = costs[0] + rec(days, costs, dp, i + 1);
        
        // Option 2
        int j = i;
        for(; j < days.length; j++){ // Runs 7 times if continuous days are found
            if(days[j] >= days[i] + 7) break;
        }
        int option2 = costs[1] + rec(days, costs, dp, j);
        
        // Option 3
        for(; j < days.length; j++){ // Runs 30 times if continuous days are found
            if(days[j] >= days[i] + 30) break;
        }
        int option3 = costs[2] + rec(days, costs, dp, j);
        
        dp[i] = Math.min(option1, Math.min(option2, option3));
        
        return dp[i];
    }
}