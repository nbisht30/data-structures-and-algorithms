package leetcode.solved.categorized.graphs.sssp.dijkstra.griddijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class P1631PathWithMinimumEffort {
    // Absolute difference -> difference without negative
    // EXPLANATION: https://leetcode.com/problems/path-with-minimum-effort/discuss/909017/JavaPython-Dijikstra-Binary-search-Clean-and-Concise

    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {max abs distance, row, col} for any node{row, col}

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int diff = node[0];
            int i = node[1];
            int j = node[2];
            if (diff > dist[i][j]) continue;
            if (i == m - 1 && j == n - 1) return diff;

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;

                int absDiff = Math.abs(heights[x][y] - heights[i][j]);
                int newDiff = Math.max(diff, absDiff);

                if (newDiff < dist[x][y]) {
                    dist[x][y] = newDiff;
                    pq.offer(new int[]{newDiff, x, y});
                }
            }
        }

        return 0;
    }

}