package leetcode.solved.categorized.dp;

import java.util.Arrays;

class P322CoinChange {
    // https://www.youtube.com/watch?v=l_nR5X9VmaI&ab_channel=Pepcoding
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1); // invalidate every thing
        dp[0] = 0;

        for (int currAmt = 0; currAmt <= amount; currAmt++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= currAmt) {
                    dp[currAmt] = Math.min(dp[currAmt], 1 +
                            dp[currAmt - coins[j]]);
                } else break; // if coins are sorted, you can break here.
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}