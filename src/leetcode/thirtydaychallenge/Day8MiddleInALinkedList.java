package leetcode.thirtydaychallenge;

/**
 * @author Nikhil Bisht
 * @date 08-04-2020
 */
public class Day8MiddleInALinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null)
            return slow;
        return slow.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
