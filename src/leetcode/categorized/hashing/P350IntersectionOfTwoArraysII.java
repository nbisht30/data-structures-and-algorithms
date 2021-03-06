package leetcode.categorized.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P350IntersectionOfTwoArraysII {
    // MYSELF
    // TIME: 13 mins
    // APPROACH: HASHING
    // TIME: 19 mins(Second Attempt)
    // COMMENTS: Got stuck with using sets

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int item : nums1) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int maxSize = nums1.length > nums2.length ? nums1.length : nums2.length, count = 0;
        int[] maxSizeArr = new int[maxSize];
        for(int item : nums2) {
            if(map.containsKey(item)){
                maxSizeArr[count++] = item;
                map.put(item, map.get(item) - 1);
                if(map.get(item) <= 0) map.remove(item);
            }
        }

        int[] intersection = new int[count];
        for(int i = 0; i < count; i++){
            intersection[i] = maxSizeArr[i];
        }
        return intersection;
    }
}