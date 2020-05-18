package leetcode.randomproblems.binarytreesandbst;

/**
 * Definition for a binary tree node.
 */
class P104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int h) {
        if (node == null) return h;
        int dL = 0, dR = 0;
        dL = maxDepth(node.left, h + 1);
        dR = maxDepth(node.right, h + 1);
        return Math.max(dL, dR);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}