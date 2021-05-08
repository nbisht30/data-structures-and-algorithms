package leetcode.solved.categorized.math.randomnumbers;

import java.util.Random;

class P382LinkedListRandomNode {

    // MYSELF
    // DATE: 02-Dec-20
    // TIME ~ 3 mins
    // Drawback: Makes two passes over the linkedlist, @TODO: learn reservoir sampling.
    int size = 0;
    Random r = new Random();
    ListNode head = null;
    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public P382LinkedListRandomNode(ListNode head) {
        ListNode itr = head;
        while (itr != null) {
            size++;
            itr = itr.next;
        }
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode itr = this.head;
        int target = r.nextInt(size);
        int index = 0;
        while (index != target) {
            index++;
            itr = itr.next;
        }
        return itr.val;
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

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */