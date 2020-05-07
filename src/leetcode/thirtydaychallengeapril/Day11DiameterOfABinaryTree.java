package leetcode.thirtydaychallengeapril;

/**
 * @author Nikhil Bisht
 * @date 04-05-2020
 */
public class Day11DiameterOfABinaryTree {
    private class TreeNode {
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
}
