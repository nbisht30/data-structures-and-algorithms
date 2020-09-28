package leetcode.solved.categorized.trees;

class P617MergeTwoBinaryTrees {
    /*
    MYSELF
    TIME: 20 Min
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 != null && t1 == null) {
            return t2;
        }
        merger(t1, t2);
        return t1;
    }

    void merger(TreeNode t1, TreeNode t2) {
        if ((t1 == null && t2 == null)) return;
        else if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;

            if (t1.right == null && t2.right != null) t1.right = t2.right;
            else if (t1.right != null && t2.right != null) merger(t1.right, t2.right);

            if (t1.left == null && t2.left != null) t1.left = t2.left;
            else if (t1.left != null && t2.left != null) merger(t1.left, t2.left);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}