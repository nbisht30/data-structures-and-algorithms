package leetcode.solved.categorized.trees;


import java.util.Collections;
import java.util.LinkedList;

class P623AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        TreeNode levelTerminal = new TreeNode();
        int currDepth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        Collections.addAll(queue, root, levelTerminal);

        while (!queue.isEmpty() && currDepth < d) {
            TreeNode curr = queue.removeFirst();
            if (curr == levelTerminal) {
                currDepth++;
                if (!queue.isEmpty()) queue.add(levelTerminal);
            } else if (curr != null) {
                queue.add(curr.left);
                queue.add(curr.right);
                if (currDepth == d - 1) {
                    curr.left = new TreeNode(v, curr.left, null);
                    curr.right = new TreeNode(v, null, curr.right);
                }
            }
        }

        return root;
    }

    public class TreeNode {
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