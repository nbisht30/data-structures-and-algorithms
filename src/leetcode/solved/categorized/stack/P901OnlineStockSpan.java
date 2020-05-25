package leetcode.solved.categorized.stack;

import java.util.LinkedList;

// https://leetcode.com/problems/online-stock-span/
class P901OnlineStockSpan {

    // To track all stock prices.
    int stockSpan[] = new int[10000];
    // To track the index of last stock price so new stock price can be inserted.
    int currInd = 0;

    // Keeps index of current price at the top and index of its max(found on the left) at top - 1
    MyStack<Integer> maxStockIndxs = new MyStack<>();

    public P901OnlineStockSpan() {

    }

    public int next(int price) {
        stockSpan[currInd] = price;
        while (!maxStockIndxs.isEmpty() && stockSpan[maxStockIndxs.peek()] <= price) {
            maxStockIndxs.pop();
        }
        int toRet = 0;
        if (maxStockIndxs.isEmpty()) toRet = currInd + 1;
        else toRet = currInd - maxStockIndxs.peek();

        maxStockIndxs.push(currInd);
        currInd++;
        return toRet;
    }

    private class MyStack<T> {
        LinkedList<T> stack = new LinkedList<>();
        int size = 0;

        boolean isEmpty() {
            return size == 0;
        }

        void push(T item) {
            this.size++;
            this.stack.addLast(item);
        }

        T pop() {
            this.size--;
            return this.stack.removeLast();
        }

        T peek() {
            return this.stack.getLast();
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */