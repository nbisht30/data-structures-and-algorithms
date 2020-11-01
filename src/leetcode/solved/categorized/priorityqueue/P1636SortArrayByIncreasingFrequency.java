package leetcode.solved.categorized.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class P1636SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> n : count.entrySet()) {
            heap.add(n);
        }

        int j = 0;
        while (!heap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            int ele = entry.getKey();
            int size = entry.getValue();
            for (int i = 0; i < size; i++) nums[j++] = ele;
        }
        return nums;
    }
}