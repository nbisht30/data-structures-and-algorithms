package leetcode.randomproblems.linkedlist;

/*
 https://leetcode.com/problems/remove-nth-node-from-end-of-list/

 */
class P19RemoveNthNodeFromEndOfLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode itr = head;

        //get n places ahead
        int i = 1;
        while (i != n) {
            itr = itr.next;
            i++;
            if (itr == null) return head.next;
        }

        if (itr.next == null) return head.next;

        ListNode itr2 = head;

        while (itr.next.next != null) {
            itr = itr.next;
            itr2 = itr2.next;
        }

        itr2.next = itr2.next.next;

        return head;
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