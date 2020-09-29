package leetcode.solved.categorized.trees;

// https://leetcode.com/problems/delete-node-in-a-bst/
class P450DeleteNodeInBST {
    TreeNode root = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        this.root = root;
        deleteUsingRoot(root, null, key, false);
        //true -> left child
        //false -> right child(false for root node also)
        return this.root;
    }

    private int maxInBstRec(TreeNode node) {
        if (node == null) return -1;  //when root is null, ie tree is empty
        if (node.right == null) return node.val;
        else return maxInBstRec(node.right);
    }

    private void deleteUsingRoot(TreeNode node, TreeNode parent, int item, boolean isLeftOfParent) {
        //isLeftOfParent > true > current node is left child of parent
        //isLeftOfParent > false > current node is right child of parent
        if (node == null) return;
        else {
            if (item < node.val) deleteUsingRoot(node.left, node, item, true);
            else if (item > node.val) deleteUsingRoot(node.right, node, item, false);
            else {
                //node to be removed has been found
                if (node.left == null && node.right == null) {  //node to be removed is leaf node
                    if (parent == null) {
                        this.root = null;
                        return;
                    }
                    if (isLeftOfParent) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (node.left == null && node.right != null) { // node to be removed has data on its right
                    if (parent == null) {
                        this.root = node.right;
                        return;
                    }
                    if (isLeftOfParent) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                } else if (node.left != null && node.right == null) { // node to be removed has data on its left
                    if (parent == null) {
                        this.root = node.left;
                        return;
                    }
                    if (isLeftOfParent) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {// node to be removed has data on both its sides
                    // First we find the max on the left side of the BST, this is also called the inorder predecessor.
                    int max = maxInBstRec(node.left);
                    node.val = max; // Change the current node's value to max
                    deleteUsingRoot(node.left, node, max, true);  //And now recursively call delete and delete this max.
                }
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}