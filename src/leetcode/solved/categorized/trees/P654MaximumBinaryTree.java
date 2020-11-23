package leetcode.solved.categorized.trees;

class P654MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }

    TreeNode construct(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (left > right) return null;

        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        }

        TreeNode newNode = new TreeNode(nums[maxIndex]);
        newNode.left = construct(nums, left, maxIndex - 1);
        newNode.right = construct(nums, maxIndex + 1, right);
        return newNode;
    }

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

}