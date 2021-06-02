package leetcode.solved.categorized.graphs.dfs;

class P695MaxAreaOfIsland {

    // MYSELF
    // DATE: 02-06-2021, first attempt
    // TIME: 23 mins
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;    
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) maxArea = Math.max(maxArea, discover(grid, vis, i, j));
            }
        }
        
        return maxArea;
    }
    
    int discover(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[i].length 
           || vis[i][j] || grid[i][j] == 0) return 0;

        vis[i][j] = true;
        
        int up = discover(grid, vis, i - 1, j);
        int down = discover(grid, vis, i + 1, j);
        int left = discover(grid, vis, i, j - 1);
        int right = discover(grid, vis, i, j + 1);
        
        return up + down + left + right + 1;
    }
}