package leetcode.solved.categorized.trees;

class P897IncreasingOrderSearchTree {
    TreeNode newRoot = null;
    TreeNode last = null;

    // Myself
    // Date: 03-Dec-20
    // Time ~ 10 mins
    // Drawback: O(n) space
    //@TODO: There is a O(h) space implementation also available
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (newRoot == null) {
            newRoot = new TreeNode(node.val);
            last = newRoot;
        } else if (last != null) {
            last.right = new TreeNode(node.val);
            last = last.right;
        }

        inorder(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}