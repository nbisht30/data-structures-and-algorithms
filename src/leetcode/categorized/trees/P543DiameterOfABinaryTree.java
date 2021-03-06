package leetcode.categorized.trees;


public class P543DiameterOfABinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] ints = diameter(root);
        return Math.max(ints[0] - 1, ints[1]);
    }

    private int[] diameter(TreeNode node) { // int heightTillNow, int maxTillNow

        if (node.left == null && node.right == null) {
            return new int[]{1, 1};
        }

        int[] left = {0, 0};
        int[] right = {0, 0};

        if (node.left != null)
            left = diameter(node.left);

        if (node.right != null)
            right = diameter(node.right);


        int[] retArr = new int[2];
        int maxHeightTillNow = Math.max(left[0], right[0]);
        retArr[0] = maxHeightTillNow + 1;
        int maxTillNow = Math.max(left[1], right[1]);
        retArr[1] = left[0] + right[0] > maxTillNow ? left[0] + right[0] : maxTillNow;
        return retArr;
    }

    class AnotherSolution {
        int maxDiameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return maxDiameter;
        }

        public int maxDepth(TreeNode curr)  {
            if(curr == null) return 0;

            // Find depth of left and right subTrees
            int maxDepthLeft = maxDepth(curr.left);
            int maxDepthRight = maxDepth(curr.right);

            // New global maxDiameter is either already reached,
            // or is acheived using this node as the root
            maxDiameter = Math.max(maxDiameter, maxDepthLeft + maxDepthRight);

            // Return height of tree rooted at this node
            return Math.max(maxDepthLeft, maxDepthRight) + 1;
        }
    }
}
