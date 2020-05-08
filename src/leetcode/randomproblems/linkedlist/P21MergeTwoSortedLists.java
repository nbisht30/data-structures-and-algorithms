package leetcode.randomproblems.linkedlist;

public class P21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode itr = start;

        while (l1 != null || l2 != null) {
            ListNode temp = null;
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }

            } else if (l1 != null && l2 == null) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            itr.next = temp;
            itr = temp;
        }
        return start.next;
    }

    private class ListNode {
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