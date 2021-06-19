package leetcode.categorized.hashing;

import java.util.ArrayList;
import java.util.List;

class P36ValidSudoku {
    // MYSELF
    // Optimization 1: Use boolean array instead of sets. In earlier submissions I used set.
    // @TODO: Optimize
    public boolean isValidSudoku(char[][] board) {
        List<boolean[]> subBoxCheckList = fillBooleanList(3);
        List<boolean[]> colmsCheckList = fillBooleanList(9);
        boolean[] row;

        for (int i = 0; i < board.length; i++) {
            row = new boolean[10];
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - 48]) {
                        return false;
                    } else row[board[i][j] - 48] = true;

                    if (colmsCheckList.get(j)[board[i][j] - 48]) {
                        return false;
                    } else colmsCheckList.get(j)[board[i][j] - 48] = true;

                    int subBoxIndex = (j / 3);
                    if (subBoxCheckList.get(subBoxIndex)[board[i][j] - 48]) {
                        return false;
                    } else {
                        subBoxCheckList.get(subBoxIndex)[board[i][j] - 48] = true;
                    }
                }
            }
            if ((i + 1) % 3 == 0) subBoxCheckList = fillBooleanList(3);
        }
        return true;
    }

    private List<boolean[]> fillBooleanList(int size) {
        List<boolean[]> list = new ArrayList<>();
        while (size != 0) {
            list.add(new boolean[10]);
            size--;
        }
        return list;
    }
}