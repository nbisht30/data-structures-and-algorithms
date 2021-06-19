package leetcode.categorized.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

class P23MergeKSortedLists {
    // MYSELF
    // DATE: 17-06-21, second attempt
    // TIME: 10 mins
    // APPROACH : Priority Queue
    /* INTUITION:
    The best data structure that comes to mind to find the smallest number among a set of ‘K’ numbers is a Heap. Let’s see how can we use a heap to find a better algorithm.
        We can insert the first element of each array in a Min Heap.
        After this, we can take out the smallest (top) element from the heap and add it to the merged list.
        After removing the smallest element from the heap, we can insert the next element of the same list into the heap.
        We can repeat steps 2 and 3 to populate the merged list in sorted order.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode merged = new ListNode();
        ListNode itr = merged;
        // Add first elements of all the lists
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            itr.next = node;
            itr = itr.next;
            if(node.next == null) continue;
            pq.add(node.next);
        }

        return merged.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}