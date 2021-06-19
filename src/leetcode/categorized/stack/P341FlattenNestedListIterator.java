package leetcode.categorized.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

public class P341FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public P341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        prepareStack(nestedList);
    }

    @Override
    public Integer next() { // Return the top of stack which will always be an integer
        return hasNext() ? stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) return true;
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }

        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> list) { // Push in stack from back to front.
        for (int i = list.size() - 1; i >= 0; i--) {
            this.stack.push(list.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */