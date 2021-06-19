package leetcode.categorized.arrays.matrices;

class P73SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int matrix00 = 1;
        
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0) matrix00 = 0;
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(matrix00 == 0) matrix[i][0] = 0;
        }
        
    }
}