package leetcode.solved.categorized.linkedlist;

class P206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode itr1 = null, itr2 = head;

        while(itr2 != null){
            ListNode nextItr2 = itr2.next;
            itr2.next = itr1;
            itr1 = itr2;
            itr2 = nextItr2;
        }

        return itr1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}