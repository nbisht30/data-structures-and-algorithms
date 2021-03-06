package leetcode.categorized.trees;

class P112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    public boolean helper(TreeNode node, int target, int curSum) {
        if (node == null) return false;
        else if (node.left == null && node.right == null && curSum + node.val == target) return true;

        return helper(node.left, target, curSum + node.val) || helper(node.right, target, curSum + node.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}