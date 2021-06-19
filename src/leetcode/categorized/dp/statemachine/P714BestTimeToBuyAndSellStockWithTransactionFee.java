package leetcode.categorized.dp.statemachine;

class P714BestTimeToBuyAndSellStockWithTransactionFee {

    // @TODO: Revisit
    // https://www.thealgorists.com/Algo/DynamicProgramming/StateMachine/StockTradingWithTransactionFee
    // https://www.youtube.com/watch?v=pTQB9wbIpfU&ab_channel=Pepcoding
    // Also check notes.
    public int maxProfit(int[] prices, int fee) {
        int hasStock = -prices[0]; // maximum profit achievable at the end of day i if we have a stock with us on end of day i.
        int noStock = 0; // maximum profit achievable at the end of day i if we have no stock with us on end of day i.

        for(int i = 1; i < prices.length; i++){
            /*
            We can transition to hasStock[i] in two ways:
            - By doing nothing, i.e, transition from hasStock[i - 1].
                hasStock[i] = hasStock[i - 1]
            - From noStock[i - 1]: by buying one stock.
                hasStock[i] = noStock[i - 1] - prices[i]

            i.e.
            Max profit achievable at the end of day i if we have a stock with us on end of day i
             = Max((Max profit by holding the existing stock and not buying the current stock)
             OR (Max profit after buying current stock if not holding any stock earlier))

            Where, Max profit after buying current stock if not holding any stock earlier =
            Max profit/money without any stock(noStock) -
            money for buying day i stock(Subtracting because buying current stock from noStock money))
            */
            hasStock = Math.max(hasStock, noStock - prices[i]);
            
            /*
            noStock[i] can be reached by two ways:
            - From noStock state of day before by doing nothing on day i.
                noStock[i] = noStock[i - 1]
            - From hasStock[i - 1] by selling stock and paying transaction fee.
                noStock[i] = hasStock[i - 1] + prices[i] - fee

            i.e
            Max profit achievable at the end of day i if we have no stock with us on end of day i =
            Max((Max profit by not buying any stock on day i and continuing with existing profit)
             OR (Max profit after selling existing stock, if holding any and paying the transaction fee))

            Where, Max profit after selling existing stock, if holding any and paying the transaction fee =
            Max profit with the existing stock + Price of the day i stock - Transaction fee
            (Since hasStock is initially started with - prices[0], i.e. it can be negative
            on adding prices[i], we actually calculate the profit by
            selling the existing stock
            */
            noStock = Math.max(noStock, hasStock + prices[i] - fee);
           
        }
        return noStock;
    }
}