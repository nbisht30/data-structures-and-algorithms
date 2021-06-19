package leetcode.categorized.stack;

import java.util.LinkedList;

class P20ValidParentheses {
    public boolean isValid(String s) {
        MyStack<Character> stack = new MyStack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if(!stack.isEmpty()){
                if((s.charAt(i) == ')' && stack.peek() == '(')
                   || (s.charAt(i) == ']' && stack.peek() == '[')
                        || (s.charAt(i) == '}' && stack.peek() == '{')) stack.pop();
                else return false;
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
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