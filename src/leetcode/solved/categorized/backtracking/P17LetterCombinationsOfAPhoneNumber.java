package leetcode.solved.categorized.backtracking;

import java.util.LinkedList;
import java.util.List;

class P17LetterCombinationsOfAPhoneNumber {
    
    
    public List<String> letterCombinations(String digits) {
        
        String[] keys = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<StringBuilder> queue = new LinkedList<>();
        LinkedList<String> retList = new LinkedList<>();
        int queueSize = 0;
        int k = 0;

        for(int i = 0; i < digits.length(); i++){
            
            String letters = keys[Character.getNumericValue(digits.charAt(i))];
            
            while(k <= queueSize){
                StringBuilder prev = new StringBuilder();
                if(!queue.isEmpty()) prev = queue.removeFirst();
                for(int j = 0; j < letters.length(); j++){
                    StringBuilder curr = new StringBuilder(prev);
                    curr.append(letters.charAt(j));
                    queue.add(curr);
                } 
                k++;
            }
            queueSize = queue.size() - 1;
            k = 0;
        }
        
        queue.forEach(a -> retList.add(a.toString()));
        
        return retList;
    }
}