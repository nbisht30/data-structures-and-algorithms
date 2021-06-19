package leetcode.categorized.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1046LastStoneWeight {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int st : stones) pq.add(st);

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(x != y) pq.add(Math.abs(x - y));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
