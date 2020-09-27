package leetcode.solved.categorized.trees;

import java.util.LinkedList;
// My article: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/867197/Explanation-of-O(1)-space-and-O(n)-time-algorithm.
class P116PopulatingNextRightPointersInEachNode {
    /*
    MYSELF
    TIME: 17.5 mins
    Intuition: Use breadth first search.
    Have one queue to maintain a level, levelQueue. Initially it contains the root node but after each iteration it would contain all the node in next level.
    In one iteration, get a node from levelQueue and point it to the next node in levelQueue, simultaneously add the node to copyQueue.
    Now copyQueue has all nodes from the current level and levelQueue is empty. Use copyQueue to get the elements of the next level and add those nodes of next level to
    the levelQueue.
    Drawback: But this approach is a bit slower as we're iterating each level twice.
     */
    public Node connect(Node root) {
        if (root == null) return root;
        LinkedList<Node> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            /*
            1. Copy the levelQueue into copyQueue and link simultaneously.
            2. Then use copyQueue to create the next level.
            So each level is being iterated twice. Time complexity would be O(2N) i.e O(N)
            and space complexity would be O(2 x (number of nodes in last level)) i.e O(number of nodes in last level)
             */
            LinkedList<Node> copyQueue = new LinkedList<>();
            Node temp = levelQueue.removeFirst();
            copyQueue.add(temp);
            while (!levelQueue.isEmpty()) {
                temp.next = levelQueue.removeFirst();
                temp = temp.next;
                copyQueue.add(temp);
            }
            while (!copyQueue.isEmpty()) {
                temp = copyQueue.removeFirst();
                if (temp.left != null) levelQueue.add(temp.left);
                if (temp.right != null) levelQueue.add(temp.right);
            }
        }
        return root;
    }

    /*
    This is faster than above implementation as it does not need two passes for each level and space wise also it just needs one queue.
    Intuition: Breadth First Search using null as an identifier for level termination along with prev and curr pointers.
    Put the first level into queue i.e. root node and null as terminator.
    Remove first from queue into curr.
    If prev is not null it means there curr comes to the right of prev so make that pointing prev.next = curr;
    Also, if curr is null it means one level has been completely read implying that all children of each node in that level would have been added into the queue,
    so close the next level by adding null again.
    If curr is not null it means that current level is still not completely read so add it's left and right to the queue at last to create the next level.
    Initialize prev = curr
     */
    public Node connectOrderNTimeAndSpace(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // null means level termination
        Node prev = null, curr = null;

        while (!queue.isEmpty()) {
            curr = queue.removeFirst();
            if (prev != null) prev.next = curr;
            if (curr == null) { // if you've reached end of level
                if (!queue.isEmpty())
                    queue.add(null); // But only add null if queue is not empty, i.e. there is an entire level already present in the queue.
            } else {
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            prev = curr;
        }
        return root;
    }

    /*
    Coded myself after understanding the approach.
    Intuition:
    If you have no node or just 0th level then return root node as it is.
    Otherwise, link the nodes in 1st level from left to right as required in the problem.
    This also prepares a linked list sort of structure for the 1st level which can be iterated
    using the next pointer as provided in Node class.
    Now the idea is to iterate this list and link the children of next level from left to right.
    and prepare a new list. But in iteration we don't make changes to the head itself, we use an iterator
    itr. Linking of nodes in next level is done using a prev pointer. If prev is null, it means
    that we've not visited even the first node of next level so, we just initialize prev. Otherwise, we
    initialize prev.next with the current child in the new level and move prev to this child.
    When the old level is completely read, itr would become null. In that case we use our head pointer
    to identify the head of next level's list which would be starting from head.left. So we initialize
    itr = head.left. Then we make head.left the new head and initialize prev = null as no node of next level
    is yet visited!
     */
    public Node connectFastest(Node root) {
        if (root == null || root.left == null) return root;
        Node head = root.left;
        head.next = root.right;
        head.next.next = null;
        Node itr = head, prev = null;
        while (itr != null) {
            if (itr.left != null) {
                if (prev != null) {
                    prev.next = itr.left;
                    prev = prev.next;
                } else prev = itr.left;
            }
            if (itr.right != null) {
                prev.next = itr.right;
                prev = prev.next;
            }
            itr = itr.next;
            if (itr == null) {
                itr = head.left;
                head = head.left;
                prev = null;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}