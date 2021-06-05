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


    // MYSELF
    // DATE: 05-06-2021, second attempt
    // TIME: 28 mins
    class SecondAttempt {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Stack<Integer> indexStack = new Stack<>();
            int[] res = new int[n];

            for(int i = n - 1; i - 1 >= 0; i--) {
                if(temperatures[i - 1] < temperatures[i]) {
                    indexStack.push(i);
                    res[i - 1] = 1;
                } else if(!indexStack.isEmpty()) {
                    while(!indexStack.isEmpty() && temperatures[indexStack.peek()] <= temperatures[i - 1]) {
                        indexStack.pop();
                    }
                    if(!indexStack.isEmpty()) {
                        res[i - 1] = indexStack.peek() - i + 1;
                    }
                }
            }

            return res;
        }
    }
}