package leetcode.categorized.arrays;

import java.util.HashMap;
import java.util.Map;

class P560SubarraySumEqualsK {
    
    // O(n) solution
    public int subarraySum(int[] nums, int k) {
        // Calculate prefix sum in each iteration
        // and put in this map if currPrefixSum - k is present in this map
        Map<Integer, Integer> gainCount = new HashMap<>();
        gainCount.put(0, 1); // A gain of 0 is present once(dafault)
        
        int currPrefSum = 0;
        int totalSubArrays = 0;

        for(int i = 0; i < nums.length; i++){
            currPrefSum += nums[i];
            
            if(gainCount.containsKey(currPrefSum - k)){
                totalSubArrays += gainCount.get(currPrefSum - k);
            }
            
            gainCount.put(currPrefSum, gainCount.getOrDefault(currPrefSum, 0 ) + 1);
        }
        
        return totalSubArrays;
    }
}