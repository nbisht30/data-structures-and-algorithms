package leetcode.solved.categorized.graphs.dfs;

class P1559DetectCyclesIn2DGrid {
    public static void main(String[] args) {
        P1559DetectCyclesIn2DGrid tester = new P1559DetectCyclesIn2DGrid();
        char[][] grid = {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
        System.out.println(tester.containsCycle(grid));
    }

    // MYSELF
    // DATE: 07-06-2021
    // TIME: 2 hrs
    // COMMENTS: Got stuck in handling some cases, like not calling dfs when next point is same as parent point
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n;j++) {

                if(!visited[i][j]) {
                    visited[i][j] = true;
                    boolean cycleExists =
                            hasCycle(grid, i + 1, j, i, j, 1, grid[i][j], visited)
                                    || hasCycle(grid, i - 1, j, i, j, 1, grid[i][j], visited)
                                    || hasCycle(grid, i, j + 1, i, j, 1, grid[i][j], visited)
                                    || hasCycle(grid, i, j - 1, i, j, 1, grid[i][j], visited);
                    if(cycleExists) return true;
                }
            }
        }
        return false;
    }

    boolean hasCycle(char[][] grid, int i, int j, int parentI, int parentJ, int pathLength, char sourceChar, boolean[][] visited) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] != sourceChar) return false;

        if(visited[i][j] && pathLength >= 4) return true;

        pathLength++;
        visited[i][j] = true;

        return ((i + 1) != parentI && hasCycle(grid, i + 1, j, i, j, pathLength, sourceChar, visited))
                || ((i - 1) != parentI && hasCycle(grid, i - 1, j, i, j, pathLength, sourceChar, visited))
                || ((j + 1) != parentJ && hasCycle(grid, i, j + 1, i, j, pathLength, sourceChar, visited))
                || ((j - 1) != parentJ && hasCycle(grid, i, j - 1, i, j, pathLength, sourceChar, visited));
    }


    // Cleaner version after taking inspiration from : https://leetcode.com/problems/detect-cycles-in-2d-grid/discuss/805677/DFS-or-Simple-Explanation
    class CleanerSolution {

        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        public boolean containsCycle(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n;j++) {
                    if(!visited[i][j] && hasCycle(grid, i, j, -1, -1, grid[i][j], visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean hasCycle(char[][] grid, int curX, int curY, int parentX, int parentY, char sourceChar, boolean[][] visited) {
            visited[curX][curY] = true;

            for(int i = 0; i < 4; i++) {
                int newX = curX + dirX[i];
                int newY = curY + dirY[i];

                if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[newX].length) {
                    if(!(newX == parentX && newY == parentY)) {

                        if(grid[newX][newY] == sourceChar) {
                            if(visited[newX][newY]) return true;
                            if(hasCycle(grid, newX, newY, curX, curY, sourceChar, visited)) return true;
                        }
                    }
                }
            }

            return false;
        }
    }
}