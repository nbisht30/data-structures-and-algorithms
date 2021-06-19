package leetcode.categorized.trees;

class P654MaximumBinaryTree {

    // MYSELF
    // DATE: 15-May-2021, second attempt
    // TIME: 8 mins
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node = helper(nums, 0, nums.length - 1);
        return node;
    }

    TreeNode helper(int[] nums, int st, int end) {
        if(st > end) return null;

        int maxInd = getMaxIndex(nums, st, end);
        TreeNode node = new TreeNode(nums[maxInd]);
        node.left = helper(nums, st, maxInd - 1);
        node.right = helper(nums, maxInd + 1, end);

        return node;
    }

    int getMaxIndex(int[] nums, int st, int end) {
        int max = st;
        while(st <= end) {
            if(nums[st] > nums[max]) max = st;
            st++;
        }
        return max;
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