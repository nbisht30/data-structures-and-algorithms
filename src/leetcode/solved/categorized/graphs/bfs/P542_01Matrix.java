package leetcode.solved.categorized.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

class P542_01Matrix {
    // @TODO: Learn the much faster DP solution for this problem

    // BFS solution:-
    // Whenever using BFS on matrix, use this(directions)
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[][]{};

        Queue<Point> queue = new LinkedList<>();
        int rows = matrix.length, cols = matrix[0].length;

        // Soluton: use BFS starting from each 0 cell and mark new length for each 1 cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Note: Need a way to differentiate original 1 and distance 1
                if (matrix[i][j] == 1) matrix[i][j] = -1;
                else queue.offer(new Point(i, j));
            }
        }

        // Start BFS from all 0s and update length wherever -1 (i.e originally 1 was found)
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;

            // Iterate overall points currently in the queue.
            for (int i = 0; i < size; i++) {
                // Get current point
                Point pt = queue.poll();

                // Check for it's adjacent elements
                for (int[] dir : dirs) {
                    int r = pt.i + dir[0];
                    int c = pt.j + dir[1];

                    // Checking if they don't exceed the boundaries
                    if (r >= 0 && c >= 0 && r < rows && c < cols) {
                        if (matrix[r][c] == -1) { // if adjacent element was -1, update its length.
                            matrix[r][c] = len;
                            queue.offer(new Point(r, c));
                        }
                    }
                }
            }
        }

        return matrix;
    }


    class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}