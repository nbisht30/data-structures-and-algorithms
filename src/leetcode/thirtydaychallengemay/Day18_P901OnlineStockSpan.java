package leetcode.thirtydaychallengemay;

import java.util.Stack;
// https://leetcode.com/problems/online-stock-span/
class Day18_P901OnlineStockSpan {

    // To track all stock prices.
    int stockSpan[] = new int[10000];
    // To track the index of last stock price so new stock price can be inserted.
    int currInd = 0;
    
    // Keeps index of current price at the top and index of its max(found on the left) at top - 1
    Stack<Integer> maxStockIndxs = new Stack<Integer>();
    public Day18_P901OnlineStockSpan() {
        
    }
    
    public int next(int price) {
        stockSpan[currInd] = price;
        
        if(currInd == 0) {
            maxStockIndxs.push(currInd);
            currInd++;
            return 1;
        }
        
        while(!maxStockIndxs.isEmpty() && stockSpan[maxStockIndxs.peek()] <= price){
            maxStockIndxs.pop();
        }
        
        int toRet = 0;
        if(maxStockIndxs.isEmpty()) toRet = currInd + 1;
        else toRet = currInd - maxStockIndxs.peek();
        
        maxStockIndxs.push(currInd);
        currInd++;
        return toRet;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */