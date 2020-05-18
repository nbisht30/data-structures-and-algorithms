package leetcode.randomproblems.arrays;

import java.util.HashMap;
import java.util.Map;

class P169MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        
        
        for(Integer num : cnt.keySet()){
            if(cnt.get(num) > nums.length/2) return num;
        }
        
        return -1;
    }
}