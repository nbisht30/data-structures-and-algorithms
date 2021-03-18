package leetcode.solved.categorized.dp.statemachine;

class P714BestTimeToBuyAndSellStockWithTransactionFee {

    // https://www.thealgorists.com/Algo/DynamicProgramming/StateMachine/StockTradingWithTransactionFee
    // https://www.youtube.com/watch?v=pTQB9wbIpfU&ab_channel=Pepcoding
    public int maxProfit(int[] prices, int fee) {
        int hasStock = -prices[0]; // maximum profit achievable at the end of day i if we have a stock with us on end of day i.
        int noStock = 0; // maximum profit achievable at the end of day i if we have no stock with us on end of day i.

        for(int i = 1; i < prices.length; i++){
            /*
            We can transition to hasStock[i] in two ways:
            - By doing nothing, i.e, transition from hasStock[i - 1].
                hasStock[i] = hasStock[i - 1]
            - From noStock[i - 1]: by buying one stock.
                hasStock[i] = noStock[i - 1] - prices[i] (Max profit/money without stock - money for buying day i stock)
            */
            hasStock = Math.max(hasStock, noStock - prices[i]);
            
            /*
            noStock[i] can be reached by two ways:
            - From noStock state of day before by doing nothing on day i.
                noStock[i] = noStock[i - 1]
            - From hasStock[i - 1] by selling stock and paying transaction fee.
                noStock[i] = hasStock[i - 1] + prices[i] - fee
            */
            noStock = Math.max(noStock, hasStock + prices[i] - fee);
           
        }
        return noStock;
    }
}