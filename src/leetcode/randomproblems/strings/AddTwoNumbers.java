package leetcode.randomproblems.strings;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        int carry = 0;
        ListNode last = new ListNode();
        ListNode first;
        first = last;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            sum = x + y + carry;
            carry = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            last.next = new ListNode(carry);
        }
        return first.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {

        }
    }
}