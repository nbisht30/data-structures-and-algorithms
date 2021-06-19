package leetcode.categorized.trees;

class P124BinaryTreeMaximumPathSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // EXPLANATION: https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    int findMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        // If max path sum from left subtree is -ve, we dont include it in max sum and just take 0
        int left = Math.max(0, findMaxPathSum(node.left));
        // If max path sum from right subtree is -ve, we dont include it in max sum and just take 0
        int right = Math.max(0, findMaxPathSum(node.right));
        // Now we calculate the maxSum, if you considering the current node as part of the path.
        // and keep the sum in global maxSum.
        maxSum = Math.max(maxSum, left + right + node.val);
        // Then we need to return something, but we cannot return a path that is also considering the current node
        // We can only return the largest path from either side + current node's value.
        return node.val + Math.max(left, right);
    }
}