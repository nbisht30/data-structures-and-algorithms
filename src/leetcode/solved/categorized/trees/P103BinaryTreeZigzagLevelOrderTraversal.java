package leetcode.solved.categorized.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class P103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> retLst = new ArrayList<>();

        // add root node into queue and to list which will be returned
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(root.val);
        retLst.add(rootLevel);

        boolean isLtoR = false;

        while (!queue.isEmpty()) {
            List<Integer> intLevel = new ArrayList<>();

            int i = 0, size = queue.size();

            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while (i < size) {
                TreeNode temp;
                if (isLtoR) {
                    temp = queue.removeLast();

                    if (temp.left != null) {
                        nextLevel.add(temp.left);
                        intLevel.add(temp.left.val);
                    }
                    if (temp.right != null) {
                        nextLevel.add(temp.right);
                        intLevel.add(temp.right.val);
                    }
                } else {
                    temp = queue.removeLast();

                    if (temp.right != null) {
                        nextLevel.add(temp.right);
                        intLevel.add(temp.right.val);
                    }
                    if (temp.left != null) {
                        nextLevel.add(temp.left);
                        intLevel.add(temp.left.val);
                    }
                }
                i++;
            }

            if (intLevel.size() > 0) retLst.add(intLevel);
            isLtoR = !isLtoR;
            queue = nextLevel;
        }
        return retLst;
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