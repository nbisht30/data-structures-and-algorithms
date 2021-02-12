package leetcode.solved.categorized.linkedlist;

/**
 * @author Nikhil Bisht
 * @date 08-04-2020
 */
public class P876MiddleInALinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode node1 = head, node2 = head;
        while(node2 != null && node2.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return node1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
