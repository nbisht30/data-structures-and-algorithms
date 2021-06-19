package leetcode.categorized.graphs.bfs;

import java.util.LinkedList;

class P1162AsFarFromLandAsPossible {

    // MYSELF
    // DATE: 03-06-2021
    // TIME: Spent 53 mins on first trying to solve using DFS, then checked the hint and solved it by
    // BFS in under 10 mins(but unoptimized).
    // INTUITION: Start from each water cell and find nearest land cell.
    class SolutionUsingBFSOnly {
        public int maxDistance(int[][] grid) {
            int n = grid.length, maxDist = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
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

    // INTUITION: Put all land cells in the queue, start exploring from all land cells till all water cells
    // are visited.
    // EXPLANATION: https://leetcode.com/problems/as-far-from-land-as-possible/discuss/360963/C%2B%2B-with-picture-DFS-and-BFS
    class OptimizedSolutionUsingBFS {
        public int maxDistance(int[][] grid) {
            int n = grid.length;
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        q.add(new int[]{i - 1, j});
                        q.add(new int[]{i + 1, j});
                        q.add(new int[]{i, j - 1});
                        q.add(new int[]{i, j + 1});
                    }
                }
            }
            q.add(new int[]{});

            int len = 1; // starting from 1 because we need to mark points visited in the first level, if we start from 0 we'll just mark them non-visited.
            while (!q.isEmpty()) {
                int[] point = q.removeFirst();
                if (point.length == 0) {
                    if (!q.isEmpty()) {
                        q.add(new int[]{});
                        len++;
                    }
                } else {
                    int i = point[0], j = point[1];
                    // otherwise add non visisted and valid neighbours to queue
                    if (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0) {
                        grid[i][j] = len;
                        q.add(new int[]{i - 1, j});
                        q.add(new int[]{i + 1, j});
                        q.add(new int[]{i, j - 1});
                        q.add(new int[]{i, j + 1});
                    }
                }
            }
            // if length is 1 we there was only either land or water in the entire grid
            // else you return len - 1 because len was started from 1
            return len == 1 ? -1 : len - 1;
        }

    }
}