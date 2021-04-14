package leetcode.solved.categorized.arrays;

class P121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int prof = 0, min = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[min]) {
                min = i;
            }else {
                prof = Math.max(prof, prices[i] - prices[min]);
            }
        }
        return prof;
    }
}