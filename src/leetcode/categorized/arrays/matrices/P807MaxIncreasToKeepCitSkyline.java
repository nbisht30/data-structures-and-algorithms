package leetcode.categorized.arrays.matrices;

class P807MaxIncreasToKeepCitSkyline {
    // MYSELF
    // DATE: 21-Nov-20
    // TIME ~ 10 mins

    // DATE: 15-May-21, second attempt
    // TIME: 9 mins, took time in understanding the question
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] ver = new int[cols];
        int[] hor = new int[rows];

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hor[i] = Math.max(hor[i], grid[i][j]);
                ver[j] = Math.max(ver[j], grid[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += Math.min(hor[i], ver[j]) - grid[i][j];
            }
        }

        return sum;
    }
}