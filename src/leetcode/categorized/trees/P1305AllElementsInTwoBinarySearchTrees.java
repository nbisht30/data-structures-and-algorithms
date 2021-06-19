package leetcode.categorized.trees;


import java.util.ArrayList;
import java.util.List;

class P1305AllElementsInTwoBinarySearchTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // MYSELF
    // DATE: 20-May-2021, second attempt
    // TIME: 10 mins
    // COMMENTS: Cleaner code than last approach.
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        inorder(root1, first);
        inorder(root2, second);

        return merge(first, second);
    }

    void inorder(TreeNode node, List<Integer> res) {
        if(node == null) return;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>(l2.size() + l1.size());

        int i = 0, j = 0;
        while(i < l1.size() || j < l2.size()) {
            if(i < l1.size() && j < l2.size()) {
                if(l1.get(i) < l2.get(j)) res.add(l1.get(i++));
                else res.add(l2.get(j++));
            } else if(i < l1.size() && i < l1.size()) {
                res.add(l1.get(i++));
            } else if(j < l2.size() && j < l2.size()) {
                res.add(l2.get(j++));
            }
        }
        return res;
    }
}