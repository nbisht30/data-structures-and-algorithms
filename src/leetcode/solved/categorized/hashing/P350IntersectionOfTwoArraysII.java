package leetcode.solved.categorized.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P350IntersectionOfTwoArraysII {
    //MYSELF
    //TIME: 13 mins
    //APPROACH: HASHING
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        List<Integer> list = new ArrayList<>(size);
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                if (map.get(i) > 1) map.put(i, map.get(i) - 1);
                else map.remove(i);
            }
        }

        int arr[] = new int[list.size()];
        int i = 0;
        for (int k : list) {
            arr[i++] = k;
        }

        return arr;
    }
}