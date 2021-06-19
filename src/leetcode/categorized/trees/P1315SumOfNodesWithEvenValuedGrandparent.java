package leetcode.categorized.trees;

import java.util.Objects;

class P1315SumOfNodesWithEvenValuedGrandparent {
    // MYSELF
    // DATE: 21-Nov-20
    // TIME ~ 5 mins 40 sec for AC

    // DATE: 15-May-21, second attempt
    // TIME: 4.5 mins

    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);
        return sum;
    }

    void helper(TreeNode node, TreeNode parent, TreeNode gp) {
        if(node == null) return;
        if(Objects.nonNull(gp) && gp.val % 2 == 0) sum += node.val;
        helper(node.left, node, parent);
        helper(node.right, node, parent);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}