package leetcode.thirtydaychallengeapril;

import java.util.Stack;

/**
 * @author Nikhil Bisht
 * @date 17-04-2020
 */
/*
Valid Parenthesis String
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 */
public class Day16ParenthesisString {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {  //To stack solution
        // Refer: https://www.youtube.com/watch?v=jNZu72XP-xQ
        /* Have two stacks,

         */
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
