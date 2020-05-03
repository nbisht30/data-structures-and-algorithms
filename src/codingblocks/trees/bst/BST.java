package codingblocks.trees.bst;

/**
 * @author Nikhil Bisht
 * @date 27-04-2020
 */
public class BST {
    private Node root;
    private int size;

    BST(int[] arr) {
        this.root = constBST(arr, 0, arr.length - 1);
    }

    private Node constBST(int[] arr, int lo, int hi) {
        if (lo > hi) return null;

        // mid
        int mid = (lo + hi) / 2;

        // create a node
        Node nn = new Node();
        nn.data = arr[mid];

        // create left
        nn.left = constBST(arr, lo, mid - 1);

        // create right
        nn.right = constBST(arr, mid + 1, hi);

        //return node for current tree
        return nn;
    }

    void add(int item) {
        addUsingRoot(root, item);
    }

    private void addUsingRoot(Node node, int item) {
        if (node == null) {
            node = new Node();
            node.data = item;
        } else {
            if (item == node.data) {
                //Already present
                System.out.println("Already present.");
            } else if (item < node.data) {
                if (node.left == null) {
                    Node temp = new Node();
                    temp.data = item;
                    node.left = temp;
                } else addUsingRoot(node.left, item);
            } else {
                if (node.right == null) {
                    Node temp = new Node();
                    temp.data = item;
                    node.right = temp;
                } else addUsingRoot(node.right, item);
            }
        }
    }

    public void displayBST() {
        System.out.println("Displaying tree:-");
        recursiveDisplay(root);
    }

    private void recursiveDisplay(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.print(node.left.data + " -> ");
        } else {
            System.out.print(". -> ");
        }
        System.out.print(node.data);
        if (node.right != null) {
            System.out.print(" <- " + node.right.data);
        } else {
            System.out.print(" <- .");
        }
        System.out.println();
        recursiveDisplay(node.left);
        recursiveDisplay(node.right);
    }

    void findItem(int data) {
        if (findUsingRoot(root, data)) System.out.println("Item present in BST.");
        else System.out.println("Item absent in BST.");
    }

    private boolean findUsingRoot(Node node, int item) {
        if (node == null) return false;
        else {
            if (item == node.data) return true;
            else if (item < node.data) return findUsingRoot(node.left, item);
            else return findUsingRoot(node.right, item);
        }
    }

    void maxInBst() {
        System.out.println(maxInBstRec(root));
    }

    private int maxInBstRec(Node node) {
        if (node == null) return -1;  //when root is null, ie tree is empty
        if (node.right == null) return node.data;
        else return maxInBstRec(node.right);
    }

    private class Node {
        int data;
        Node left;
        Node right;
    }
}
