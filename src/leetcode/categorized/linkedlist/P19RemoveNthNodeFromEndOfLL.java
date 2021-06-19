package leetcode.categorized.linkedlist;

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
    }
}