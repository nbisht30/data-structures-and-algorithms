package leetcode.solved.categorized.backtracking;

import java.util.LinkedList;

class P1286CombinationIterator {

    // NEEDED HELP
    // APPROACH: BACKTRACKING
    // EXPLANATION: https://www.youtube.com/watch?v=UOy4IAjvajY
    // DATE: 28-05-2021
    LinkedList<String> queue;

    public P1286CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        fillQueueWithCombinations(characters, combinationLength, 0, new StringBuilder());
    }
    
    public void fillQueueWithCombinations(String str, int target, int i, StringBuilder sb){
        if(sb.length() == target){
            queue.add(sb.toString());
            return;
        }
        
        if(i == str.length()) return;
        
        // Include current character.
        sb.append(str.charAt(i));
        fillQueueWithCombinations(str, target, i + 1, sb);
        
        // Backtracked! And exclude current character.
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        fillQueueWithCombinations(str, target, i + 1, sb);
    }
    
    public String next() {
        if(queue.size() > 0) return queue.removeFirst();
        else return null;
    }
    
    public boolean hasNext() {
        if(queue.size() > 0) return true;
        else return false;
    }
}

/**
 * Your P1286CombinationIterator object will be instantiated and called as such:
 * P1286CombinationIterator obj = new P1286CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */