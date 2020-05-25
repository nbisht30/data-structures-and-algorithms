package leetcode.solved.categorized.linkedlist;

class P206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode itr = null;
        while(head!=null){
            ListNode temp = new ListNode(head.val);
            temp.next = itr;
            itr = temp;
            head = head.next;
        }
        return itr;
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