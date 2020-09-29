package leetcode.solved.categorized.trees;


class P404SumOfLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root, false);
        return sum;
    }

    public void helper(TreeNode curr, boolean dir) { // true if from left

        if (curr.left == null && curr.right == null) {
            if (dir) {
                sum += curr.val;
            }
            return;
        }

        if (curr.left != null) helper(curr.left, true);
        if (curr.right != null) helper(curr.right, false);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}