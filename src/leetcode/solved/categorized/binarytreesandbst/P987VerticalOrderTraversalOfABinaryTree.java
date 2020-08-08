package leetcode.solved.categorized.binarytreesandbst;

import java.util.*;

class P987VerticalOrderTraversalOfABinaryTree {
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
    
    class Point{
        TreeNode node;
        int horiDist; //from left to right
        int vertDist; //from top to bottom
        
        Point(TreeNode node, int horiDist, int vertDist){
            this.node = node;
            this.horiDist = horiDist;
            this.vertDist = vertDist;
        }
    }
    
    Comparator<Point> comparator = (a, b) -> {
        if(a.vertDist == b.vertDist){
            return a.node.val - b.node.val;
        }else{
            return a.vertDist - b.vertDist;
            }
        };
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> retList = new ArrayList<>();
        
        Map<Integer, PriorityQueue<Point>> levelMap = new HashMap<>();
        int [] minmax = new int[2];

        
        fillMapFromTree(levelMap, 0, 0, root, minmax);
        
        for(int i = minmax[0]; i <= minmax[1]; i++){
            if(levelMap.containsKey(i)){
                PriorityQueue<Point> pq = levelMap.get(i);
                List<Integer> tempList = new ArrayList<>();
                while(!pq.isEmpty()){
                    tempList.add(pq.poll().node.val);
                }
                retList.add(tempList);
            }
        }
        return retList;
    }
    
    public void fillMapFromTree(Map<Integer, PriorityQueue<Point>> levelMap, int horiDist, int vertDist, TreeNode curr, int[] minmax){
        if(curr == null) return;

        levelMap.putIfAbsent(horiDist, new PriorityQueue<>(comparator));
        levelMap.get(horiDist).add(new Point(curr, horiDist, vertDist));
        
        if(curr.left != null){
            minmax[0]--;
            fillMapFromTree(levelMap, horiDist - 1, vertDist + 1, curr.left, minmax);
        }
        if(curr.right!=null){
            minmax[1]++;
            fillMapFromTree(levelMap, horiDist + 1, vertDist + 1, curr.right, minmax);
        }
    }
}