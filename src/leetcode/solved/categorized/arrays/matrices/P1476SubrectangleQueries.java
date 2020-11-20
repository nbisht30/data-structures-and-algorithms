package leetcode.solved.categorized.arrays.matrices;

class P1476SubrectangleQueries {

    int[][] matrix;

    public P1476SubrectangleQueries(int[][] rectangle) {
        matrix = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (matrix == null
                || row1 < 0 || col1 < 0 || row1 > row2 || col1 > col2
                || row2 >= matrix.length || col2 >= matrix[0].length)
            return;

        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                matrix[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        if (matrix == null || row >= matrix.length
                || col >= matrix[0].length) return -1;

        return matrix[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */