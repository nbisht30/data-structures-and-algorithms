package leetcode.randomproblems.linkedlist;
/*
WOW! Solved my first hard problem, that too without any help at first attempt!
Was also able to optimize it to beat 100% submissions in second attempt!
I am really seeing the improvements now!

https://leetcode.com/problems/merge-k-sorted-lists/
 */
class P23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode temp = mergeParentLists(lists, 0, lists.length - 1);
        return temp;
    }

    private ListNode mergeParentLists(ListNode[] lists, int start, int end) {
        ListNode headLeft = null;
        ListNode headRight = null;
        int mid = (start + end) / 2;
        if (start == end) return lists[start];
        else if (start == end - 1) return merge(lists[start], lists[end]);
        headLeft = mergeParentLists(lists, start, mid);
        headRight = mergeParentLists(lists, mid + 1, end);

        return merge(headLeft, headRight);
    }

    private ListNode merge(ListNode l, ListNode r) {

        ListNode sortedListHead = new ListNode(0);
        ListNode tail = sortedListHead;


        while (l != null && r != null) {
            if (l.val <= r.val) {
                tail.next = l;
                l = l.next;
            } else {
                tail.next = r;
                r = r.next;
            }
            tail = tail.next;
        }


        if (l != null) { //r finished first because r had more smaller nodes
            // and larger nodes of l are left, with l currently pointing to the first node
            // of all those larger nodes
            tail.next = l;
            l = l.next;
        }

        if (r != null) {
            tail.next = r;
            r = r.next;
        }

        return sortedListHead.next;
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