package leetcode.categorized.trees;

import java.util.HashMap;
import java.util.Map;

class P437PathSumIII {
    // O(n) approach
    int totalPaths = 0; // Global

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        Map<Integer, Integer> gainMap = new HashMap<>();
        gainMap.put(0, 1);

        findPathSum(root, sum, 0, gainMap);

        return totalPaths;
    }

    public void findPathSum(TreeNode root, int sum, int currSum, Map<Integer, Integer> gainMap) {
        if (root == null) return;

        currSum += root.val;

        if (gainMap.containsKey(currSum - sum)) {
            totalPaths += gainMap.get(currSum - sum);
        }

        gainMap.put(currSum, gainMap.getOrDefault(currSum, 0) + 1);

        findPathSum(root.left, sum, currSum, gainMap);
        findPathSum(root.right, sum, currSum, gainMap);

        // To reduce currSum count while backtracking
        gainMap.put(currSum, gainMap.get(currSum) - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    
    
    /*
    // O(n^2) approach
    int totalPaths = 0; // Global
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        
        findPathSum(root, sum, 0);
        // Perform the same operation for child nodes also.
        pathSum(root.left, sum); 
        pathSum(root.right, sum);
        
        return totalPaths;
    }
    
    public void findPathSum(TreeNode root, int sum, int currSum){
        if(root == null) return;
        
        currSum += root.val;
        
        if(currSum == sum) totalPaths++;
        
        findPathSum(root.left, sum, currSum);
        findPathSum(root.right, sum, currSum);
    }
    */
}