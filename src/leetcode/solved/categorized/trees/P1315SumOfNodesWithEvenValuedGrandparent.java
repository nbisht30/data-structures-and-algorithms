package leetcode.solved.categorized.trees;

class P1315SumOfNodesWithEvenValuedGrandparent {
    int sum = 0;
    // MYSELF
    // DATE: 21-Nov-20
    // TIME ~ 5 mins 40 sec for AC
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root.left, root, null);
        dfs(root.right, root, null);
        return sum;
    }

    void dfs(TreeNode node, TreeNode parent, TreeNode gp) {
        if (node == null) return;
        if (gp != null && gp.val % 2 == 0) sum += node.val;
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}