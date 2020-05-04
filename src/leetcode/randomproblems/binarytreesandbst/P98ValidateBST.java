package leetcode.randomproblems.binarytreesandbst;


public class P98ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isBTaBSTRec(root, -Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBTaBSTRec(TreeNode node, long rangeMin, long rangeMax) {
        if (node == null) return true; //if tree has no node
        if (node.val >= rangeMax || node.val <= rangeMin) {
            return false;
        }
        boolean overallStatus = true;

        if (node.left != null)
            overallStatus &= isBTaBSTRec(node.left, rangeMin, node.val);
        if (!overallStatus) return false;

        if (node.right != null) overallStatus &= isBTaBSTRec(node.right, node.val, rangeMax);
        return overallStatus;
    }

    private class TreeNode {
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