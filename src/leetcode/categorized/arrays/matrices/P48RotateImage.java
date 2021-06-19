package leetcode.categorized.arrays.matrices;

class P48RotateImage {
    public void rotate(int[][] matrix) {
        // Step 1:Transpose | swap(matrix[i][j], matrix[j][i]);
        for(int i = 0; i < matrix.length; i++){ 
            for(int j = i; j < matrix[i].length; j++){ // important to start j from i otherwise the resulting array would be same as original array
                // as elements would get swapped twice
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
            
        // Step 2: Flip Horizontally | swap(matrix[i][j], matrix[i][N - j - 1])
        for(int i = 0; i < matrix.length; i++){  // i goes from 0 to N to check for all rows.
            for(int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

