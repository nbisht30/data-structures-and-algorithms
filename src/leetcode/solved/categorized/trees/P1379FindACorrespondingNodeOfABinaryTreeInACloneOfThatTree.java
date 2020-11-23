package leetcode.solved.categorized.trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    TreeNode dest;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        helper(original, cloned, target);
        return dest;
    }
    
    void helper(TreeNode original, TreeNode cloned, TreeNode target){
        if(original == null) return;
        if(original == target) {
            dest = cloned;
            return;
        }
        helper(original.left, cloned.left, target);
        helper(original.right, cloned.right, target);
        return;
    }
}