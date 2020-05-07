package leetcode.randomproblems.binarytreesandbst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class P102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> mainList = new ArrayList<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        List<Integer> nextLevelNodes = new ArrayList<>();
        nextLevelNodes.add(root.val);

        while (list.size() > 0) {
            mainList.add(nextLevelNodes);
            nextLevelNodes = new ArrayList<>();
            List<TreeNode> tempList = new ArrayList<>();
            Iterator<TreeNode> itr = list.listIterator();
            while (itr.hasNext()) {
                TreeNode node = itr.next();
                if (node.left != null) {
                    tempList.add(node.left);
                    nextLevelNodes.add(node.left.val);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                    nextLevelNodes.add(node.right.val);
                }
            }
            list = tempList;
        }
        return mainList;
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