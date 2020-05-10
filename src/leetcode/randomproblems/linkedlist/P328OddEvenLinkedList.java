package leetcode.randomproblems.linkedlist;
//https://leetcode.com/problems/odd-even-linked-list/
class P328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddSt = null, oddTail = null, evenSt = null, evenTail = null, tmp = null;

        boolean firstEvenFound = false, firstOddFound = false;
        int i = 1;

        // A node is considered odd if it is at an odd position in the LL and even if at even position at LL
        // It is not on the actual value stored in that node.
        while (head != null) {
            tmp = head.next;

            if (i % 2 == 0) {
                head.next = null;
                if (!firstEvenFound) {
                    evenSt = head;
                    evenTail = head;
                    firstEvenFound = true;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }

            } else {
                head.next = null;
                if (!firstOddFound) {
                    oddSt = head;
                    oddTail = head;
                    firstOddFound = true;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            }
            head = tmp;
            i++;
        }

        oddTail.next = evenSt;

        return oddSt;

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