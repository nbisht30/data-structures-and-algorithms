package leetcode.thirtydaychallenge;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class Day5StockBuySell {
    public static void main(String[] args) {
        System.out.println(maxProfitBruteForce(new int[]{}));
    }

    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
