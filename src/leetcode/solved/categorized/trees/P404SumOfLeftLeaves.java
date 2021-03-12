package leetcode.solved.categorized.trees;


class P404SumOfLeftLeaves {
    // Time: 2.5 mins on resolving streak
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }

    void helper(TreeNode node, boolean isLeft){
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft) sum += node.val;
        helper(node.left, true);
        helper(node.right, false);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}