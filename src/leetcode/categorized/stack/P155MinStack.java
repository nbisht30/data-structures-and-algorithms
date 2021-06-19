package leetcode.categorized.stack;

import java.util.Stack;


public class P155MinStack {

    //Using two stacks
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
