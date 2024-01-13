package leetcode.categorized.dp;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class P122BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {  //Simple one pass
        int profit = 0, lastPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(price > lastPrice) profit += price - lastPrice;
            lastPrice = price;
        }
        return profit;
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

