package leetcode.solved.categorized.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class P637AverageOfLevelsInBinaryTree {

    // Myself
    // 5 mins
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) return averages;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        double levelSum = 0;
        int levelSize = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                averages.add(levelSum / levelSize);
                levelSum = 0;
                levelSize = 0;
                if (!queue.isEmpty()) queue.add(null);
            } else {
                levelSum += node.val;
                levelSize++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return averages;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}