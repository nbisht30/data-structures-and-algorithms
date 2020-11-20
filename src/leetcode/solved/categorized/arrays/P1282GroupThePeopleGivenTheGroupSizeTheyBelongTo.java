package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P1282GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++){
            int groupSize = groupSizes[i];
            map.putIfAbsent(groupSize, new ArrayList<>());
            List<Integer> lastGroup = map.get(groupSize);

            if(lastGroup.size() < groupSize){
                if(lastGroup.size() == 0) result.add(lastGroup);
                lastGroup.add(i);
            } else {
                List<Integer> nextGroup = new ArrayList<>();
                nextGroup.add(i);
                result.add(nextGroup);
                map.put(groupSize, nextGroup);
            }
        }

        return result;
    }
}