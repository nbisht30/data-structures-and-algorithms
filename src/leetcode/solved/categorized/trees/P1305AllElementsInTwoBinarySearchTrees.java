package leetcode.solved.categorized.trees;


import java.util.ArrayList;
import java.util.List;

class P1305AllElementsInTwoBinarySearchTrees {
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getInorder(root1, new ArrayList<>());
        List<Integer> list2 = getInorder(root2, new ArrayList<>());
        return merge(list1, list2);
    }
    
    public List<Integer> getInorder(TreeNode node, List<Integer> list){
        if(node == null) return list;
        
        if(node.left != null) list = getInorder(node.left, list);
        
        list.add(node.val);
        
        if(node.right != null) list = getInorder(node.right, list);

        return list;
    }
    
    public List<Integer> merge(List<Integer> l1, List<Integer> l2){
        List<Integer> res = new ArrayList<>(l1.size() + l2.size());
        
        int i = 0, j = 0;
        
        while(i < l1.size() && j < l2.size()){
            if(l2.get(j) < l1.get(i)) {
                res.add(l2.get(j));
                j++;
            }
            else {
                res.add(l1.get(i));
                i++;
            }
        }
        
        while(i < l1.size()){
            res.add(l1.get(i));
            i++;
        }
        
        while(j < l2.size()){
            res.add(l2.get(j));
            j++;
        }
        
        return res;
    }
}