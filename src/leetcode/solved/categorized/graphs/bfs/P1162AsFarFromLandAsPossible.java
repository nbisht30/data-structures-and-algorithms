package leetcode.solved.categorized.graphs.bfs;

import java.util.LinkedList;

class P1162AsFarFromLandAsPossible {

    // MYSELF
    // DATE: 03-06-2021, first attempt
    // TIME: Spent 53 mins on first trying to solve using DFS, then checked the hint and solved it by
    // BFS in under 10 mins.
    class SolutionUsingBFSOnly{
        public int maxDistance(int[][] grid) {
            int n = grid.length, maxDist = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 0) {
                        int closestOne = getClosestOneByBFS(grid, i, j);
                        maxDist = Math.max(closestOne, maxDist);
                    }
                }
            }
            return maxDist;
        }

        int getClosestOneByBFS(int[][] grid, int stI, int stJ) {
            int n = grid.length, len = 0;
            boolean vis[][] = new boolean[n][n];
            LinkedList<int[]> q = new LinkedList<>();
            q.add(new int[]{stI, stJ});
            q.add(new int[]{});
            vis[stI][stJ] = true;
            while (!q.isEmpty()) {
                int[] point = q.removeFirst();
                if (point.length == 0) {
                    if (!q.isEmpty()) q.add(new int[]{});
                    len++;
                } else {
                    int i = point[0], j = point[1];
                    if (grid[i][j] == 1) return len;
                    // otherwise add neighbours to queue
                    if (i - 1 >= 0 && !vis[i - 1][j]) {
                        vis[i - 1][j] = true;
                        q.add(new int[]{i - 1, j});
                    }
                    if (i + 1 < n && !vis[i + 1][j]) {
                        vis[i + 1][j] = true;
                        q.add(new int[]{i + 1, j});
                    }
                    if (j - 1 >= 0 && !vis[i][j - 1]) {
                        vis[i][j - 1] = true;
                        q.add(new int[]{i, j - 1});
                    }
                    if (j + 1 < n && !vis[i][j + 1]) {
                        vis[i][j + 1] = true;
                        q.add(new int[]{i, j + 1});
                    }
                }
            }
            return -1;
        }
    }
}