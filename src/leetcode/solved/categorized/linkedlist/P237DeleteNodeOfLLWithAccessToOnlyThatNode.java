package leetcode.solved.categorized.linkedlist;
// https://leetcode.com/problems/delete-node-in-a-linked-list/
class P237DeleteNodeOfLLWithAccessToOnlyThatNode {

    public void deleteNode(ListNode node) {
        ListNode slNode = null;
        while (node.next != null) {
            slNode = node;
            node.val = node.next.val;
            node = node.next;
        }
        slNode.next = null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}