package leetcode.categorized.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class P199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode curr = null, prev = null;
        while (!q.isEmpty()) {
            curr = q.removeFirst();
            if (curr == null) {
                list.add(prev == null ? -1 : prev.val);
                if (!q.isEmpty()) q.add(null);
            } else {
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            prev = curr;
        }
        return list;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}