package leetcode.categorized.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class P1636SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? (b.getKey() - a.getKey()) : a.getValue() - b.getValue());
        pq.addAll(count.entrySet());

        int currIndex = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int key = entry.getKey();
            int keyCount = entry.getValue();
            for(int i = 0; i < keyCount; i++){
                nums[currIndex++] = key;
            }
        }
        return nums;
    }
}