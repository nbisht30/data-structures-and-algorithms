package leetcode.solved.categorized.arrays.matrices;

import java.util.ArrayList;
import java.util.List;

class P54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;

        int rows = matrix.length, cols = matrix[0].length;

        // i same, j inc cols times, rows--
        // j same, i inc rows times, cols--
        // i same, j dec cols times, rows--
        // j same, i dec rows times, cols--

        int i = 0, j = 0;

        while (rows > 0 && cols > 0) {
            for (int itr = 0; itr < cols && rows > 0; itr++) {
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            rows--;
            for (int itr = 0; itr < rows && cols > 0; itr++) {
                list.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            cols--;
            for (int itr = 0; itr < cols && rows > 0; itr++) {
                list.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            rows--;
            for (int itr = 0; itr < rows && cols > 0; itr++) {
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            cols--;
        }

        return list;
    }
}