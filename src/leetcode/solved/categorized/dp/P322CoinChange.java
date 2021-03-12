package leetcode.solved.categorized.dp;

import java.util.Arrays;

class P322CoinChange {
    // https://www.youtube.com/watch?v=l_nR5X9VmaI&ab_channel=Pepcoding
    // Code: https://www.youtube.com/watch?v=1R0_7HqNaW0&ab_channel=KevinNaughtonJr.
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // invalidate the entire dp array with a greater value
        Arrays.sort(coins);
        dp[0] = 0; // number of coins needed to make 0
        for(int currAmt = 0; currAmt <= amount; currAmt++){
            for(int j = 0; j < coins.length; j++){
                int coinTaken = coins[j];
                if(coins[j] <= currAmt) {
                    // we can only take the current coin if its value
                    // is less than the amount we're trying to make
                    dp[currAmt] = Math.min(dp[currAmt], 1 + dp[currAmt - coins[j]]);
                }  else break;  // if coins are sorted, you can break here.
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}