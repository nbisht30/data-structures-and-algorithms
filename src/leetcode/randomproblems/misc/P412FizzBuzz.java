package leetcode.randomproblems.misc;

import java.util.ArrayList;
import java.util.List;

class P412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> retStr = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0) retStr.add("FizzBuzz");
            else if(i % 3 == 0) retStr.add("Fizz");
            else if(i % 5 == 0) retStr.add("Buzz");
            else retStr.add(i+"");
        }
        
        return retStr;
    }
}