package leetcode.solved.categorized.stack;

import java.util.Stack;

/**
 * @author Nikhil Bisht
 * @date 08-04-2020
 */
//https://leetcode.com/problems/min-stack/
public class P155MinStack {


    //Using two stacks
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public static void main(String[] args) {
        P155MinStack minStack = new P155MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> Returns -3.
        minStack.pop();
        minStack.top();      //--> Returns 0.
        minStack.getMin();   //--> Returns -2.
    }

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
