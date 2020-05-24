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
}