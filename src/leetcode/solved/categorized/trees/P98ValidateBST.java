package leetcode.solved.categorized.trees;


public class P98ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isBTaBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBTaBSTRec(TreeNode node, long rangeMin, long rangeMax) {
        if (node == null) return true; //if tree has no node
        if (node.val >= rangeMax || node.val <= rangeMin) {
            return false;
        }
        if (node.left != null)
            if(!isBTaBSTRec(node.left, rangeMin, node.val)) return false;

        if (node.right != null)
            if(!isBTaBSTRec(node.right, node.val, rangeMax)) return false;
        return true;
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