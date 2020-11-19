package leetcode.solved.categorized.priorityqueue;

import java.util.*;
// @TODO: Learn how to solve this using bucket sort.
class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("eeeeaaadrr"));
    }

    /*
    Resolved:
    18-Nov-20
     */
    public static String frequencySort(String s) {
        if(s.length() == 0) return s;

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            int cnt = entry.getValue();
            char ch = entry.getKey();
            while(cnt > 0) {
                sb.append(ch);
                cnt--;
            }
        }

        return sb.toString();
    }
}