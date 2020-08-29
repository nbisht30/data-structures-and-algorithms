package leetcode.solved.categorized.hashingandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class P229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) > (double) nums.length / 3) list.add(i);
        }
        return list;
    }
}