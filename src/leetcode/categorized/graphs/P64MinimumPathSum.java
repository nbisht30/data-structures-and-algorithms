package leetcode.categorized.graphs;

class P64MinimumPathSum {

    // MYSELF
    // DATE: 20-05-2021
    // TIME: 15 mins
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return find(grid, 0, 0, dp);
    }
    
    int find(int[][] grid, int i, int j, int[][] dp) {
        
        if(i < grid.length && j < grid[i].length && dp[i][j] > 0) return dp[i][j];
        
        if(i == grid.length || j == grid[i].length) return Integer.MAX_VALUE;
        
        if(i == grid.length - 1 && j == grid[i].length - 1) return grid[i][j];
        
        int right = find(grid, i + 1, j, dp);
        int down = find(grid, i, j + 1, dp);
        
        dp[i][j] = Math.min(right, down) + grid[i][j];
        
        return dp[i][j];
    }
}