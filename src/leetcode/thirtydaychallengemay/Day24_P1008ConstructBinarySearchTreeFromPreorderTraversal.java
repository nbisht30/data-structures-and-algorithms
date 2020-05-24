package leetcode.thirtydaychallengemay;

class Day24_P1008ConstructBinarySearchTreeFromPreorderTraversal {
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

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }


    // My implementation but this is slower as it is O(n2);
    private TreeNode helper(int[] preorder, int st, int end){ 
        if(st == end) return new TreeNode(preorder[st]);
        
        if(st > end) return null;
        
        int lSt, lEnd, rSt, rEnd;
        TreeNode root = new TreeNode(preorder[st]); 
        
        // finding out start and end for left and right subtrees
        lSt = lEnd = st + 1;
        while(lEnd < preorder.length && preorder[lEnd] < root.val){ 
            lEnd++;
        }
        lEnd --; 
        rSt = lEnd + 1;
        rEnd = end; 
        
        root.left = helper(preorder, lSt, lEnd); 
        
        root.right = helper(preorder, rSt, rEnd);
        
        return root;
    }

    // O(n) solution: Idea : Have upper bound for each node you're trying to construct. For left subtree the upper bound would be
    // root's value and for right subtree the upper bound would be max upper bound.
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
    class Solution {
        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, Integer.MAX_VALUE);
        }

        private TreeNode helper(int[] preorder, int upperBound){
            if(i == preorder.length || preorder[i] > upperBound) return null;

            TreeNode root = new TreeNode(preorder[i++]);

            root.left = helper(preorder, root.val);

            root.right = helper(preorder, upperBound);

            return root;
        }
    }
}