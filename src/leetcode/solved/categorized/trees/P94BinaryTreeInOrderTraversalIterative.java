package leetcode.solved.categorized.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class P94BinaryTreeInOrderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderItr(list, root);
        return list;
    }

    private void inorderRec(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        inorderRec(list, node.left);
        list.add(node.val);
        inorderRec(list, node.right);
    }

    private void inorderItr(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> holder = new Stack<>();
        holder.push(node);  //push root to holder stack

        while (!holder.empty()) {  //iterate till holder is not empty
            node = node.left;  //get the left node
            if (node != null) { //if left node is null dont push to holder, otherwise push.(this would put all left nodes to stack)
                holder.push(node);
            } else {
                // Since node is null, at top of stack is a node with no left node, pushed in earlier iteration
                node = holder.pop(); //Get that node using pop()
                list.add(node.val); //Add it to the traversal
                while (node.right == null && !holder.empty()) { //Check if doest not have a right,
                    //and keep popping and adding nodes to traversal till you find nodes having no right node.
                    node = holder.pop();
                    list.add(node.val);
                }
                if (node.right != null) { //Finally if node.right was not null, go to the right node and push it to holder
                    //again repeating the process
                    node = node.right;
                    holder.push(node);
                }
            }
        }
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