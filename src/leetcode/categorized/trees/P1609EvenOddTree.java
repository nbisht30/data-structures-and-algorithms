package leetcode.categorized.trees;

import java.util.LinkedList;

class P1609EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean evenLevel = true;
        TreeNode prev = null;
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node == null) {
                if (q.isEmpty()) break;
                q.add(null);
                evenLevel = !evenLevel;
            } else {
                if (evenLevel) {
                    if (node.val % 2 == 0) return false;
                    if (prev != null && node.val <= prev.val) return false;
                } else {
                    if (node.val % 2 != 0) return false;
                    if (prev != null && node.val >= prev.val) return false;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            prev = node;
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}