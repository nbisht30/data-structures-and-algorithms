package leetcode.categorized.linkedlist;

class P1669MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1, end = list1;
        for (int i = 0; i <= b; i++) {
            if (i == a - 1) start = end;
            end = end.next;
        }
        start.next = list2;
        while (list2.next != null) list2 = list2.next;
        list2.next = end;
        return list1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}