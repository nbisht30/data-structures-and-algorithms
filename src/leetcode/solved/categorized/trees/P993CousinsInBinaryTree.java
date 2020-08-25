package leetcode.solved.categorized.trees;

/**
 * @author Nikhil Bisht
 * @date 07-05-2020
 */
public class P993CousinsInBinaryTree {
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

    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;
            int[] depthXY = new int[2];
            getDepth(depthXY, null, root, x, y, 0, false);
            if (depthXY[0] == 0 && depthXY[1] == 0) return false;
            if (depthXY[0] == depthXY[1]) return true;
            return false;
        }

        private void getDepth(int[] depth, TreeNode parent, TreeNode node, int x, int y, int d, boolean isLeft) {
            if (parent != null) {
                if (node.val == x) {
                    if (depth[1] == 0) {
                        if (isLeft) {
                            if (parent.right != null && parent.right.val == y) {
                                return;
                            }
                        } else {
                            if (parent.left != null && parent.left.val == y) {
                                return;
                            }
                        }
                    }
                    depth[0] = d;
                }
                if (node.val == y) {
                    if (depth[0] == 0) {
                        if (isLeft) {
                            if (parent.right != null && parent.right.val == x) {
                                return;
                            }
                        } else {
                            if (parent.left != null && parent.left.val == x) {
                                return;
                            }
                        }
                    }
                    depth[1] = d;
                }
            }
            if (node.left != null) getDepth(depth, node, node.left, x, y, d + 1, true);
            if (node.right != null) getDepth(depth, node, node.right, x, y, d + 1, false);
        }
    }
}
