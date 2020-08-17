package leetcode.solved.categorized.arrays;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class P122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {  //Simple one pass
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

        public int maxProfitUsingSameApproachAsBTBSS1(int[] prices) { // Same idea as Best Time to Buy and Sell Stock-I
            int lastMin = Integer.MAX_VALUE;
            int profit = 0;

            for(int i = 0; i < prices.length; i++){
                if(prices[i] < lastMin){
                    lastMin = prices[i];
                }else{
                    if(prices[i] > lastMin){
                        profit += prices[i] - lastMin;
                        lastMin = prices[i];
                    }
                }
            }

            return profit;
        }
}

