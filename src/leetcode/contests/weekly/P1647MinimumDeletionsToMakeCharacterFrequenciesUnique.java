package leetcode.contests.weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P1647MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc"));
    }
    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

        int minDel = 0;
        Set<Integer> set = new HashSet<>();
        for (Character ch : map.keySet()) {
            if (set.contains(map.get(ch))) {
                while (map.get(ch) != 0 && set.contains(map.get(ch))) {
                    minDel++;
                    map.put(ch, map.get(ch) - 1);
                }
            }
            if (map.get(ch) > 0) set.add(map.get(ch));
        }

        return minDel;
    }
}