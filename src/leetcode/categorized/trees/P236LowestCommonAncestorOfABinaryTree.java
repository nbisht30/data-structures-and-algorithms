package leetcode.categorized.trees;

class P236LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    /*
    INTUITION: If from any node curr, you find that you can reach the p node and the q node then curr is the LCA,
    and you return it backwards through recursion.

    ALGORITHM:
    If curr is null return null
    If you've reached p or q in the recursion, return curr.
    If above two conditions have not met, search on the left subtree and on the right subtree.
    If result of left subtree is null, it means neither p or q was found on the left subtree, so return right subtree's result.
    (Here, right might be null as well. In that case result of both left and right is equal, so we return the result i.e. not found in both left and right)
    If result of right subtree is null, it means neither p or q was found on the right subtree, so return left subtree's result.
    (Here, left might be null as well. In that case result of both left and right is equal, so we return the result i.e. not found in both left and right)
    If both are not null, then it means curr must be the LCA as it is giving paths to both p and q, so return curr back eventually to the caller through recursive tree.
     */
    public TreeNode lca(TreeNode curr, TreeNode p,
                        TreeNode q) {
        if (curr == null || curr.val == p.val || curr.val == q.val) return curr;
        TreeNode leftSearchRes = lca(curr.left, p, q);
        TreeNode rightSearchRes = lca(curr.right, p, q);
        if (leftSearchRes == null) return rightSearchRes;
        if (rightSearchRes == null) return leftSearchRes;
        return curr;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}