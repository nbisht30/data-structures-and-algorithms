package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    // MYSELF
    // DATE: 15-May-21, second attempt
    // TIME ~ 6 mins
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int gs = groupSizes[i];
            map.putIfAbsent(gs, new ArrayList<>());
            if (map.get(gs).size() == gs) {
                res.add(map.get(gs));
                map.remove(gs);
                map.put(gs, new ArrayList<>());
            }
            map.get(gs).add(i);
        }

        for (int gs : map.keySet()) {
            res.add(map.get(gs));
        }
        return res;
    }
}