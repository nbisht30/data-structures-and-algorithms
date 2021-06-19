package leetcode.categorized.trees;

class P1448CountGoodNodesInBinaryTree {
    // MYSELF
    // DATE: 11-06-21
    // TIME: 3.5 min
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    
    void dfs(TreeNode node, int currMax) {
        if(node == null) return;
        
        if(node.val >= currMax) {
            currMax = node.val;
            count++;
        }
        
        dfs(node.left, currMax);
        dfs(node.right, currMax);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}