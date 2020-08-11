package leetcode.solved.categorized.priorityqueue;

import java.util.PriorityQueue;

class P295FindMedianFromDataStream {
    // To store lower half of data stream eg. 1, 2, 3, 6
    PriorityQueue<Integer> lowerHalf;
    // To store upper half of data stream eg. 8, 9, 11
    PriorityQueue<Integer> upperHalf;

    /**
     * initialize your data structure here.
     */
    public P295FindMedianFromDataStream() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a); // Max heap : To fetch largest
        // element from lower half in O(1) time
        upperHalf = new PriorityQueue<>(); // Min heap : To fetch lowest
        // element from upper half in O(1) time
    }

    public void addNum(int num) {
        // Insert in lowerHalf is it's empty or if number being inserted is less than the peek of lowerHalf otherwise insert in upperHalf
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        // We also need to ensure that the halves are balanced i.e. there is no more than a difference of 1 in size of both halves
        // Let lowerHalf be the one to hold one extra element if the size of total data stream is odd otherwise be equal to upperHalf
        if (upperHalf.size() > lowerHalf.size()) { // If an element added above made upperHalf have one more element than lowerHalf then we poll it and put it into lowerHalf
            lowerHalf.add(upperHalf.poll());
        } else if (lowerHalf.size() > upperHalf.size() + 1) {
            // If an element added above, made lowerHalf have 2 more elements then upperHalf then we put one into upperHalf from lowerHalf
            upperHalf.add(lowerHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (double) (lowerHalf.peek() + upperHalf.peek()) / 2;
        } else {
            return (double) (lowerHalf.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */