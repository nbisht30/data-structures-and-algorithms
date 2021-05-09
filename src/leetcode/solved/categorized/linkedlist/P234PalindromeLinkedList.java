package leetcode.solved.categorized.linkedlist;
// https://leetcode.com/problems/palindrome-linked-list/
class P234PalindromeLinkedList {

    // MYSELF
    // TIME: 30 Mins
    // DATE: 09-May-2021, second attempt.
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, revHead = null, prev = null;
        // reversing half the linked list(revHead becomes the head after the loop)
        // and keeping the other half intact(slow becomes the head after the loop).
        while(fast != null && fast.next != null) {
            revHead = slow;
            slow = slow.next;
            fast = fast.next.next;
            revHead.next = prev;
            prev = revHead;
        }

        // if the list has odd number of nodes then fast is not equal to null,
        // and slow will be at the middle node, and middle can be ignored in palindrome comparison.
        if(fast != null) slow = slow.next;

        while(revHead != null && slow != null) {
            if(revHead.val != slow.val) return false;
            revHead = revHead.next;
            slow = slow.next;
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