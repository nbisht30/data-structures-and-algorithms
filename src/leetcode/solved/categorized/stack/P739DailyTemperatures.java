package leetcode.solved.categorized.stack;

import java.util.Stack;

class P739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] days = new int[N];
        Stack<Integer> indexStack = new Stack<>();
        for(int i = N - 1; i >= 0; i--){
            while(!indexStack.isEmpty() && T[indexStack.peek()] <= T[i]) indexStack.pop();
            if(!indexStack.isEmpty()) {
                days[i] = indexStack.peek() - i;
            }else{
                days[i] = 0;
            }
            indexStack.push(i);
        }
        return days;
    }
}