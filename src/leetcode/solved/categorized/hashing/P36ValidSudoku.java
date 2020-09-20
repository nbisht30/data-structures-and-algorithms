package leetcode.solved.categorized.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P36ValidSudoku {
    // MYSELF
    // @TODO: Optimize
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> subBoxSets = fillEmptySet(3);
        List<Set<Character>> colsSets = fillEmptySet(9);
        Set<Character> row;

        for (int i = 0; i < board.length; i++) {
            row = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    } else row.add(board[i][j]);

                    if (colsSets.get(j).contains(board[i][j])) {
                        return false;
                    } else colsSets.get(j).add(board[i][j]);

                    int subBoxIndex = (j / 3);
                    if (subBoxSets.get(subBoxIndex).contains(board[i][j])) {
                        return false;
                    } else {
                        subBoxSets.get(subBoxIndex).add(board[i][j]);
                    }
                }
            }
            if ((i + 1) % 3 == 0) subBoxSets = fillEmptySet(3);
        }
        return true;
    }

    private List<Set<Character>> fillEmptySet(int numSets) {
        List<Set<Character>> listOfSets = new ArrayList<>();
        while (numSets != 0) {
            listOfSets.add(new HashSet<>());
            numSets--;
        }
        return listOfSets;
    }
}