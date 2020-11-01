package leetcode.solved.categorized.stack;

import java.util.Stack;

class P150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-/*".contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                if (token.equals("+")) stack.push(x + y);
                else if (token.equals("-")) stack.push(x - y);
                else if (token.equals("*")) stack.push(x * y);
                else stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}