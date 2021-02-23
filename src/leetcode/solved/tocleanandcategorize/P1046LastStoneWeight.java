package leetcode.solved.tocleanandcategorize;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */
public class P1046LastStoneWeight {

    public static void main(String[] args) {
//        System.out.println(lastStoneWeight(new int[]{12, 7, 42, 9, 8, 13, 11}));
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for(int st : stones) pq.add(st);

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(x != y) pq.add(Math.abs(x - y));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
