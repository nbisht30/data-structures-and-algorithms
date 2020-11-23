package leetcode.solved.categorized.trees;

class P1038BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    int helper(TreeNode node, int startingPoint) {
        if (node == null) return 0 + startingPoint;

        int right = helper(node.right, startingPoint);
        node.val = right + node.val;
        int left = helper(node.left, node.val);
        return left;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}