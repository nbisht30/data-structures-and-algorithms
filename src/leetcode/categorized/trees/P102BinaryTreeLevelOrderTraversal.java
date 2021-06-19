package leetcode.categorized.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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

    // This is my attempt when I performed revision: THIS IS MUCH MORE CLEANER! I am improving.
    public List<List<Integer>> levelOrderRevisionAttempt(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> retList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> intLevel = new ArrayList<>();

            int i = 0, size = queue.size();
            while(i < size){
                TreeNode temp = queue.removeFirst();
                intLevel.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                i++;
            }
            if(intLevel.size() > 0) retList.add(intLevel);
        }

        return retList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


}