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

    BST() {
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

    public void recursiveDisplay(Node node) {
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

    void deleteNode(int data) {
        deleteUsingRoot(root, null, data, false);
        //true -> left child
        //false -> right child(false for root node also)
    }

    private void deleteUsingRoot(Node node, Node parent, int item, boolean isLeftOfParent) {
        //isLeftOfParent > true > current node is left child of parent
        //isLeftOfParent > false > current node is right child of parent
        if (node == null) return;
        else {
            if (item < node.data) deleteUsingRoot(node.left, node, item, true);
            else if (item > node.data) deleteUsingRoot(node.right, node, item, false);
            else {
                //node to be removed has been found
                if (node.left == null && node.right == null) {  //node to be removed is leaf node
                    if (isLeftOfParent) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (node.left == null && node.right != null) { // node to be removed has data on its right
                    if (isLeftOfParent) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                } else if (node.left != null && node.right == null) { // node to be removed has data on its left
                    if (isLeftOfParent) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {// node to be removed has data on both its sides
                    int max = maxInBstRec(node.left);
                    node.data = max;
                    deleteUsingRoot(node.left, node, max, true);
                }
            }
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

    // Construct BST from preorder traversal
    public Node bstFromPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    private Node helper(int[] preorder, int i[], int limit) {
        if (i[0] == preorder.length || preorder[i[0]] > limit) return null;
        int rootval = preorder[i[0]];

        Node root = new Node();
        root.data = rootval;

        i[0]++;

        root.left = helper(preorder, i, rootval);
        root.right = helper(preorder, i, limit);
        return root;
    }

    public class Node {
        int data;
        Node left;
        Node right;
    }
}
