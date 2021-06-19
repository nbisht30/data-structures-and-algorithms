package leetcode.categorized.linkedlist;

class P143ReorderList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head, fast = head;

        // 1. Divide the list into two halves
        ListNode tmp  = null;
        while(fast != null && fast.next != null){
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tmp.next = null; // to end the first half

        // 2. Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;  // Slow is the head for second half.
        ListNode next = null;
        while(curr != null){
            next = curr.next; // temporarily store next node
            curr.next = prev; // have prev appended at curr's next
            prev = curr; // make curr the prev for next iteration, at last when next would be null
            //prev will be the start node
            curr = next; // take curr to next using the temporary storage
        }
        ListNode revHead = prev;

        // 3. Merge the two LLs
        curr = head; // For first half
        tmp = null;
        while(curr != null && revHead != null){
            tmp = curr.next; // temporarily hold the remaining first half except current element

            curr.next = revHead; // make the current element point to head of reversed list
            curr = curr.next; // move curr forward

            revHead = revHead.next; // move revHead forward

            if(tmp == null && revHead != null) curr.next = revHead; // If size of main list is odd
                // first half would have n / 2 - 1 elements and get iterated first. In this case tmp would become
                // null due to assignment on line 43 and reversed list would still have one item
                // so we assign it to curr.next
            else curr.next = tmp;
            curr = tmp;
        }
    }
}