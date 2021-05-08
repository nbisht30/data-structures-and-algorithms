package leetcode.solved.categorized.trees;

import java.util.LinkedList;
import java.util.Queue;

class P1302DeepestLeavesSum {
    // MYSELF
    // DATE: 21-Nov-20
    // TIME ~ 3 mins 13 sec for AC
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) break;
                q.add(null);
                sum = 0;
                continue;
            } else sum += curr.val;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return sum;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}