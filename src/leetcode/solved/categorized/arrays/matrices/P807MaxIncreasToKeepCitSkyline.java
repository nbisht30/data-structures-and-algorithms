package leetcode.solved.categorized.arrays.matrices;

class P807MaxIncreasToKeepCitSkyline {
    // Myself
    // Date: 21-Nov-20
    // Time ~ 10 mins
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] verticalView = new int[cols];
        int[] horizontalView = new int[rows];

        for (int i = 0; i < rows; i++) {
            int horizontalMax = Integer.MIN_VALUE;
            for (int j = 0; j < cols; j++) {
                verticalView[j] = Math.max(verticalView[j], grid[i][j]);
                horizontalMax = Math.max(horizontalMax, grid[i][j]);

            }
            horizontalView[i] = horizontalMax;
        }

        int sumInc = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumInc += Math.min(horizontalView[i], verticalView[j]) - grid[i][j];
            }
        }

        return sumInc;
    }
}