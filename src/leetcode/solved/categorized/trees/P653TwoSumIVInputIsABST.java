package leetcode.solved.categorized.trees;

import java.util.HashSet;
import java.util.Set;

class P653TwoSumIVInputIsABST {
    Set<Integer> set = new HashSet<>();
    boolean flag = false;

    public boolean findTarget(TreeNode root, int k) {
        helper(root, k);
        return flag;
    }

    public void helper(TreeNode node, int k) {
        if (node == null) return;
        if (set.contains(k - node.val)) {
            flag = true;
            return;
        }
        set.add(node.val);
        helper(node.left, k);
        helper(node.right, k);
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