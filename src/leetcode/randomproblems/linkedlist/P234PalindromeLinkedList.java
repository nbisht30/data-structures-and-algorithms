package leetcode.randomproblems.linkedlist;
// https://leetcode.com/problems/palindrome-linked-list/
class P234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        ListNode tmp = null;
        ListNode prev = null;

        // Find middle as well as reverse the first part of the list till middle.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        if (fast != null) {
            slow = slow.next; //Now slow becomes the start of list after middle.
        }
        //prev at this stage is the start of the reversed first list.
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    // Used below two methods first to do each of these operations separately
    // But to save time we can do them both in a single pass
    private ListNode findMiddle(ListNode start) {
        ListNode sp = start, fp = start;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        return sp;
    }

    private ListNode inPlaceReversal(ListNode start) {
        ListNode prev = start;
        start = start.next;
        prev.next = null;

        ListNode temp = null;

        while (start != null) {
            temp = start;
            start = start.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}