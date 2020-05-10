package leetcode.randomproblems.linkedlist;

// https://leetcode.com/problems/sort-list/
public class P148SortedLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode fast = head, slow = head;
        
        ListNode temp = null;
         
        // Find mid for list/sublists
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Then split from mid
        temp.next = null;
        
        // Repeat the process for left list
        ListNode leftSide = sortList(head);
        
        // And repeat the process for right list
        ListNode rightSide = sortList(slow);
        
        // Now start merging if we are down to single nodes
        head = merge(leftSide, rightSide);
        
        return head;
    }
    
    private ListNode merge(ListNode l, ListNode r){
        
        ListNode sortedListHead = new ListNode(0);
        ListNode tail = sortedListHead;
        
        
        while(l != null && r != null){
            if(l.val <= r.val){
                tail.next = l;
                l = l.next;
            }else{
                tail.next = r;
                r = r.next;
            }
            tail = tail.next;
        }
        
        
        if(l != null) { //r finished first because r had more smaller nodes 
            // and larger nodes of l are left, with l currently pointing to the first node
            // of all those larger nodes
            tail.next = l;
            l = l.next;
        }
        
        if(r != null) {
            tail.next = r;
            r = r.next;
        }
        
        return sortedListHead.next;
    }
}