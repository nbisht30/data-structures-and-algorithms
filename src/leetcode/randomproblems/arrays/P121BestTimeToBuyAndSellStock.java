package leetcode.randomproblems.arrays;

class P121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int lastMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lastMin){
                lastMin = prices[i];
            }
            else if(prices[i] - lastMin > maxProfit) maxProfit = prices[i] - lastMin;
        }
        
        return maxProfit;
    }
}