package leetcode.solved.categorized.linkedlist;

public class P160IntersectionOfTwoLinkedLists {
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

    // MYSELF
    // DATE: 08-May-2021, second attempt
    // TIME: 5 mins
    // COMMENTS: Improved over the last attempt, wrote cleaner code
    public ListNode getIntersectionNodeAttemptTwo(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;

        ListNode temp = headA;
        while(temp!= null) {
            temp = temp.next;
            countA++;
        }

        temp = headB;
        while(temp!= null) {
            temp = temp.next;
            countB++;
        }

        while(headA != headB){
            if(countA > countB) {
                headA = headA.next;
                countA--;
            } else if(countB > countA) {
                headB = headB.next;
                countB--;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return headA;
    }
}