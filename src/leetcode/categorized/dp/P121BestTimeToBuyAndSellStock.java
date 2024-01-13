package leetcode.categorized.dp;

class P121BestTimeToBuyAndSellStock {

    // SOLVER: MYSELF
    // DATE: 23-May-21, fourth attempt
    // TIME: 1 min
    // INTUITION: Keep track of the current minimum price of the stock, keep checking for maximum profit with each day's price.
    // TC: O(N)

    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = Integer.MIN_VALUE;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

