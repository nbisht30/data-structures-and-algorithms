package leetcode.solved.categorized.randomnumbers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class P380RandomizedSet {

    Set<Integer> set;
    Random random;
    
    /** Initialize your data structure here. */
    public P380RandomizedSet() {
        random = new Random();
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randInt = random.nextInt(set.size());
        int index = 0;
        
        for(int i : set){
            if(index == randInt)
                return i;
            index++;
        }
        
        return 0;
    }
}

/**
 * Your P380RandomizedSet object will be instantiated and called as such:
 * P380RandomizedSet obj = new P380RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */