package codingblocks.trees.binarytrees;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Nikhil Bisht
 * @date 11-04-2020
 */
public class BinaryTree {
    private Node root;
    private int size; //Total number of nodes in the tree.

    BinaryTree() {
        this.size = 0;
        Scanner in = new Scanner(System.in);
        this.root = buildBinaryTree(null, in, false);
    }

    private Node buildBinaryTree(Node parent, Scanner in, boolean isLeft) {
        if (parent == null) {
            System.out.println("Enter data for root node: ");
        } else {
            if (isLeft) {
                System.out.println("Enter data for the left child of parent: " + parent.data);

            } else {
                System.out.println("Enter data for the right child of parent: " + parent.data);
            }
        }
        int data = in.nextInt();
        Node temp = new Node(data, null, null);

        System.out.println("Do you have a left child for this parent: " + data + "?");
        boolean choice = in.nextBoolean();
        if (choice) temp.left = buildBinaryTree(temp, in, true);
        System.out.println("Do you have a right child for this parent: " + data + "?");
        choice = in.nextBoolean();
        if (choice) temp.right = buildBinaryTree(temp, in, false);
        return temp;
    }

    public void display() {
        displayTree(root);
    }

    private void displayTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " => ");
        if (node.left != null) {
            System.out.print(node.left.data + ",");
        }
        if (node.right != null) {
            System.out.print(node.right.data + ",");
        }
        System.out.println("END");
        displayTree(node.left);
        displayTree(node.right);
    }

    public int heightOfTree() {
        int left = traverseAndGetLongestEdge(root.left, 0);
        int right = traverseAndGetLongestEdge(root.right, 0);
        return Math.max(left, right);
    }

    private int traverseAndGetLongestEdge(Node node, int h) {
        if (node == null) {
            return h;
        }
        h++;
        int left = h, right = h;
        if (node.left != null) {
            left = traverseAndGetLongestEdge(node.left, h);
        }
        if (node.right != null) {
            right = traverseAndGetLongestEdge(node.right, h);
        }
        return Math.max(left, right);
    }

    /*
    Node -> Left Child of Node -> Right Child of Node
    This is just like the display function we've written above, but we won't show same node as a child of any other node and then showing its children separately,
    each node data is printed just once.
    Pre-order traversal is like you are going through the edges of the tree anticlockwise visiting the unvisited nodes.
     */
    public void preOrderTraversal() {
        preOrderThroughRoot(root);
        System.out.println();
    }

    private void preOrderThroughRoot(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderThroughRoot(node.left);
        preOrderThroughRoot(node.right);
    }

    /*
    Left Child of Node -> Node -> Right Child of Node
    Inorder traversal is like you have compressed the tree from the top to a single line, and you are reading nodes from left to right end of that line.
     */
    public void inorderTraversal() {
        inorderThroughRoot(root);
        System.out.println();
    }

    private void inorderThroughRoot(Node node) {
        if (node == null)
            return;
        inorderThroughRoot(node.left);
        System.out.print(node.data + " ");
        inorderThroughRoot(node.right);
    }

    /*
    Left Child of Node -> Right Child of Node -> Node
    */
    public void postOrderTraversal() {
        postOrderThroughRoot(root);
        System.out.println();
    }

    private void postOrderThroughRoot(Node node) {
        if (node == null)
            return;
        preOrderThroughRoot(node.left);
        preOrderThroughRoot(node.right);
        System.out.print(node.data + " ");
    }

    /*
    Nodes at level 0 -> Nodes at level 1 -> Nodes at level 2 .....

    To understand this best, do a dry run.

    */
    public void levelOrderTraversal() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node removed = queue.removeFirst();
            System.out.print(removed.data + " ");
            if (removed.left != null) queue.add(removed.left);
            if (removed.right != null) queue.add(removed.right);
        }

        System.out.println();
    }

    boolean isBTaBST() {
        return isBTaBSTRec(root, -Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Leetcode: https://leetcode.com/problems/validate-binary-search-tree/submissions/
    private boolean isBTaBSTRec(Node node, long rangeMin, long rangeMax) {
        if (node == null) return false; //if tree has no node
        if (node.data > rangeMax || node.data < rangeMin) {
            return false;
        }
        boolean overallStatus = true;

        if (node.left != null)
            overallStatus &= isBTaBSTRec(node.left, rangeMin, node.data);
        if (!overallStatus) return false;

        if (node.right != null) overallStatus &= isBTaBSTRec(node.right, node.data, rangeMax);
        return overallStatus;
    }

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
