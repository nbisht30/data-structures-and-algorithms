package leetcode.thirtydaychallengemay;

class Day19_P230KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int res[] = new int[1];
        helper(root, k, new int[]{0}, res);
        return res[0];
    }

    private void helper(TreeNode node, int k, int[] curK, int[] res) {
        if (node.left != null) {
            helper(node.left, k, curK, res);
        }

        curK[0]++;
        if (k == curK[0]) {
            res[0] = node.val;
            return;
        }

        if (node.right != null) {
            helper(node.right, k, curK, res);
        }
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