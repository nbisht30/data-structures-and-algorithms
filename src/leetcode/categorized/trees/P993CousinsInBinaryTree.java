package leetcode.categorized.trees;


public class P993CousinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // TIME : 7:43 mins
    class Solution {
        TreeNode xParent, yParent;
        int xDepth, yDepth;
        public boolean isCousins(TreeNode root, int x, int y) {
            helper(root, null, x, y, 0);
            if(xParent == yParent || xDepth != yDepth) return false;
            else return true;
        }

        void helper (TreeNode node, TreeNode parent, int x, int y, int depth) {
            if(node == null) return;
            if(node.val == x) {
                xParent = parent;
                xDepth = depth;
                return;
            }
            if(node.val == y) {
                yParent = parent;
                yDepth = depth;
                return;
            }
            helper(node.left, node, x, y, depth + 1);
            helper(node.right, node, x, y, depth + 1);
        }
    }
}
