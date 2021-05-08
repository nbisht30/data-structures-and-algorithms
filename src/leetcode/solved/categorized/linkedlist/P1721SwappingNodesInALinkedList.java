package leetcode.solved.categorized.linkedlist;

class P1721SwappingNodesInALinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // MYSELF
    // TIME < 10 mins
    public ListNode swapNodes(ListNode head, int k) {
        ListNode itr = head;
        while (k > 1) {
            itr = itr.next;
            k--;
        }
        ListNode kthNodeStart = itr;
        ListNode kthNodeEnd = head;
        while (itr.next != null) {
            itr = itr.next;
            kthNodeEnd = kthNodeEnd.next;
        }

        int val = kthNodeStart.val;
        kthNodeStart.val = kthNodeEnd.val;
        kthNodeEnd.val = val;
        return head;

    }
}