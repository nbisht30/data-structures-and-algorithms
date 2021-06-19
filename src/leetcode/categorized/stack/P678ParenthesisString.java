package leetcode.categorized.stack;

import java.util.Stack;

public class P678ParenthesisString {

    // EXPLANATION: https://www.youtube.com/watch?v=jNZu72XP-xQ
    public static boolean checkValidString(String s) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> astStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftStack.push(i);
            else if (s.charAt(i) == '*') astStack.push(i);
            else {
                if (!leftStack.empty()) leftStack.pop();
                else if(!astStack.empty()) astStack.pop();
                else return false;
            }
        }

        if(astStack.size() < leftStack.size()) return false;

        while(!leftStack.empty()){
            if(leftStack.peek() > astStack.peek()) return false;
            else {
                leftStack.pop();
                astStack.pop();
            }
        }
        return true;
    }
}
