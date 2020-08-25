package leetcode.solved.categorized.trees;

class P1008ConstructBinarySearchTreeFromPreorderTraversal {
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


    // My implementation, but this is slower as it is O(n2);
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

    /*
    O(n) Solution
    Intuition:-
    https://www.youtube.com/watch?v=RyAGEb4VWo0

    Eg. if the preorder is [8, 5, 1, 7, 10, 12] then 8 is surely the root element.

    Now you need to put everything to the left of 8 till you encounter an element that is greater than 8 i.e 10.
    And after that everything is to be put to the right of 8.

    So, root.left = i+1th element if it is lower than roots value
    and root.right = i+1th element if it is higher than the roots value and less than the max limit.

    Same process repeats for all the subtrees under root.

    Note: Using array, i[] to store the index because I need a reference variable here. So that we
    get the value in every recursive call.

    Another Explanation:-
    Idea : Have upper bound for each node you're trying to construct. For left subtree the upper bound would be
    root's value and for right subtree the upper bound would be max upper bound.
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution

     */
    private TreeNode helper(int[] preorder, int i[], int limit) {
        if (i[0] == preorder.length || preorder[i[0]] > limit) return null;
        int rootval = preorder[i[0]];

        TreeNode root = new TreeNode();
        root.val = rootval;

        i[0]++;

        root.left = helper(preorder, i, rootval);
        root.right = helper(preorder, i, limit);
        return root;
    }
}