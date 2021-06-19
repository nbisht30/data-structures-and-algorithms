package leetcode.categorized.arrays;

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

    public int majorityElementBoyerMoore(int[] nums) {
        // Boyer-Moore algo
        int majorityElement = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(majorityElement == nums[i]) count++;
            else {
                count--;
                if(count == 0) {
                    majorityElement = nums[i];
                    count = 1;
                }
            }
        }
        return majorityElement;
    }
}