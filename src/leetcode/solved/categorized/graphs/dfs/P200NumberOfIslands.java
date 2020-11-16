package leetcode.solved.categorized.graphs.dfs;

class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ans += dfs(grid, m, n, visited, r, c);
            }
        }
        return ans;
    }

    int[] DIR = new int[]{0, 1, 0, -1, 0};

    int dfs(char[][] grid, int m, int n, boolean[][] visited, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n || visited[r][c] || grid[r][c] == '0') return 0;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            dfs(grid, m, n, visited, r + DIR[i], c + DIR[i + 1]);
        }
        return 1;
    }
}