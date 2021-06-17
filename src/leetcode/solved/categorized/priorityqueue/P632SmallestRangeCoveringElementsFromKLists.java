package leetcode.solved.categorized.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class P632SmallestRangeCoveringElementsFromKLists {
    // PREREQUISITE: Merge K Sorted Lists
    // EXPLANATION: https://www.youtube.com/watch?v=usuTLFmYnr8&ab_channel=StableSort
    // NEEDED HELP
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Put first number from each list to minHeap
        int maxPq = Integer.MIN_VALUE; // maximum number in the pq at one time
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            int first = list.get(0);
            maxPq = Math.max(maxPq, first);
            pq.offer(new Pair(first, list.iterator()));
        }
        // Now, pq contains one number which is the first element, from every list
        int[] range = new int[2];
        range[1] = maxPq;
        int minRange = Integer.MAX_VALUE; // worst case min range
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int curVal = pair.val;
            Iterator<Integer> itr = pair.itr;

            if (maxPq - curVal < minRange) {
                minRange = maxPq - curVal;
                range[0] = curVal;
                range[1] = maxPq;
            }

            if (itr.hasNext()) {
                int nextVal = itr.next();
                Pair nextPair = new Pair(nextVal, itr);
                pq.offer(nextPair);
                maxPq = Math.max(maxPq, nextVal); // update new max while putting the new element in queue
            } else break; // if one of the lists gets exhausted, exit from the loop, because the property of queue was to have one element from each list!

        }

        return range;
    }

    class Pair {
        int val;
        Iterator<Integer> itr;

        Pair(int val, Iterator<Integer> itr) {
            this.val = val;
            this.itr = itr;
        }
    }

}