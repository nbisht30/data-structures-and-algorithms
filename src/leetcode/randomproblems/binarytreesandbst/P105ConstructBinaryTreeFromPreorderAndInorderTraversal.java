package leetcode.randomproblems.binarytreesandbst;

import java.util.HashMap;
import java.util.Map;

class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{4, 1, 2, 3}, new int[]{1, 2, 3, 4});
    }

    /* My Solution
    Intuition: First element of preorder is the root of the tree and if we search for that root in inorder, then left side
    of that root in inroder is the left subtree and right side is right subtree.

    To find the indexes of root elements in inorder array, we can either loop in every recursive call, or just maintain a Map
    to store indices corresponding to element values: ioIndexMap
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // Prepare a map
        Map<Integer, Integer> ioIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            ioIndexMap.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, ioIndexMap);
        return root;
    }

    private static TreeNode helper(int[] preorder, int poSt, int poEnd,
                                   int[] inorder, int ioSt, int ioEnd,
                                   Map<Integer, Integer> ioIndexMap) {

        if (poSt > poEnd || ioSt > ioEnd) return null;

        TreeNode root = new TreeNode(preorder[poSt]); // Create root from root ind of Inorder

        int ioRoot = ioIndexMap.get(root.val);
        int sizeOfLeft = ioRoot - ioSt;

        root.left = helper(preorder, poSt + 1, poSt + sizeOfLeft, inorder, ioSt, ioRoot - 1, ioIndexMap);
        root.right = helper(preorder, poSt + sizeOfLeft + 1, poEnd, inorder, ioRoot + 1, ioEnd, ioIndexMap);

        return root;
    }

    private static class TreeNode {
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

/*
1. PO: 3 | 9 10 12 11 | 20 15 7
=> root = 3


IO: 12 10 9 11 | 3 | 15 20 7
=> values to the left of 3 is make all left subtree and to right make right subtree
*/
