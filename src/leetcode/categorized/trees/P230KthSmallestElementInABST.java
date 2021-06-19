package leetcode.categorized.trees;

// @TODO: Understand the optimal solution: https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
class P230KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int res[] = new int[1];
        helper(root, k, new int[]{0}, res);
        return res[0];
    }

    private void helper(TreeNode node, int k, int[] curK, int[] res) {
        if (node.left != null) {
            helper(node.left, k, curK, res);
        }

        curK[0]++;
        if (k == curK[0]) {
            res[0] = node.val;
            return;
        }

        if (node.right != null) {
            helper(node.right, k, curK, res);
        }
    }


    // MYSELF
    // DATE: 06-06-21, second attempt
    // TIME: 12:20 mins
    class SecondAttempt {
        int k;
        int kthSmall = 0;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            findKth(root);
            return kthSmall;
        }

        void findKth(TreeNode node) {
            if(node == null) return;

            findKth(node.left);

            k--;
            if(k == 0) {
                kthSmall = node.val;
                return;
            }

            findKth(node.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}