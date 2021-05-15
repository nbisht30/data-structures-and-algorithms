package leetcode.solved.categorized.trees;

class P1038BinarySearchTreeToGreaterSumTree {
    // MYSELF
    // DATE: 15-May-2021, second attempt.
    // TIME: 9 Mins
    public TreeNode bstToGst(TreeNode root) {
        sum(root, 0);
        return root;
    }

    int sum(TreeNode node, int currSum) {
        if(node == null) return currSum;

        int rightSum = sum(node.right, currSum);
        node.val = node.val + rightSum;
        int leftSum = sum(node.left, node.val);

        return leftSum;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}