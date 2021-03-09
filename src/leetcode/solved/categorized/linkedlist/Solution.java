package leetcode.solved.categorized.linkedlist;

public class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode itr = headA;
        
        while(itr != null){
            itr = itr.next;
            sizeA++;
        }
        
        itr = headB;
        while(itr != null){
            itr = itr.next;
            sizeB++;
        }
        
        while(sizeA > sizeB){
            headA = headA.next;
            sizeA--;
        }
        
        while(sizeB > sizeA){
            headB = headB.next;
            sizeB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
            sizeA--;
            sizeB--;
        }
        
        return sizeA == 0 ? null : headA;
    }
}