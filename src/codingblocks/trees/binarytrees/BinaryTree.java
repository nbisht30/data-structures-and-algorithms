package codingblocks.trees.binarytrees;

import java.util.*;

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

    //LC: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
    public int getDiameter() {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] ints = diameterOfBinaryTree(root);
        return Math.max(ints[0] - 1, ints[1]);
    }

    private int[] diameterOfBinaryTree(Node node) { // int heightTillNow, int maxTillNow

        if (node.left == null && node.right == null) {
            return new int[]{1, 1};
        }

        int[] left = {0, 0};
        int[] right = {0, 0};

        if (node.left != null)
            left = diameterOfBinaryTree(node.left);

        if (node.right != null)
            right = diameterOfBinaryTree(node.right);


        int[] retArr = new int[2];
        int maxHeightTillNow = Math.max(left[0], right[0]);
        retArr[0] = maxHeightTillNow + 1;
        int maxTillNow = Math.max(left[1], right[1]);
        retArr[1] = left[0] + right[0] > maxTillNow ? left[0] + right[0] : maxTillNow;
        return retArr;
    }

    boolean isBTaBST() {
        return isBTaBSTRec(root, -Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // LC: https://leetcode.com/problems/dataidate-binary-search-tree/submissions/
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


    // LC: https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(int x, int y) {
        if (root == null) return false;
        int[] depthXY = new int[2];
        getDepth(depthXY, null, root, x, y, 0, false);
        if (depthXY[0] == -1 && depthXY[1] == -1) return false;
        if (depthXY[0] == depthXY[1]) return true;
        return false;
    }

    private void getDepth(int[] depth, Node parent, Node node, int x, int y, int d, boolean isLeft) {
        if (parent != null) {
            if (node.data == x) {
                if (depth[1] == 0) {
                    if (isLeft) {
                        if (parent.right != null && parent.right.data == y) {
                            depth[0] = depth[1] = -1;
                            return;
                        }
                    } else {
                        if (parent.left != null && parent.left.data == y) {
                            depth[0] = depth[1] = -1;
                            return;
                        }
                    }
                }
                depth[0] = d;
            }
            if (node.data == y) {
                if (depth[0] == 0) {
                    if (isLeft) {
                        if (parent.right != null && parent.right.data == x) {
                            depth[0] = depth[1] = -1;
                            return;
                        }
                    } else {
                        if (parent.left != null && parent.left.data == x) {
                            depth[0] = depth[1] = -1;
                            return;
                        }
                    }
                }
                depth[1] = d;
            }
        }
        if (node.left != null) getDepth(depth, node, node.left, x, y, d + 1, true);
            if (node.right != null) getDepth(depth, node, node.right, x, y, d + 1, false);
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
