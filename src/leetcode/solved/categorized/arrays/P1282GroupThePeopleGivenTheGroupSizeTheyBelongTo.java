package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            map.putIfAbsent(groupSize, new ArrayList<>());
            if (map.get(groupSize).size() == 0) {
                List<Integer> firstGroup = new ArrayList<>();
                map.get(groupSize).add(firstGroup);
            }
            List<List<Integer>> groups = map.get(groupSize);
            List<Integer> lastList = groups.get(groups.size() - 1);
            if (lastList.size() < groupSize) {
                if (lastList.size() == 0) result.add(lastList);
                lastList.add(i);
            } else {
                List<Integer> nextGroup = new ArrayList<>();
                nextGroup.add(i);
                result.add(nextGroup);
                groups.add(nextGroup);
                map.put(groupSize, groups);
            }
        }

        return result;
    }
}