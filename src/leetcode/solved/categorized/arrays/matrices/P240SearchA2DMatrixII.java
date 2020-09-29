package leetcode.solved.categorized.arrays.matrices;

class P240SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length - 1, i = m, j = 0;

        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }

        return false;
    }
}