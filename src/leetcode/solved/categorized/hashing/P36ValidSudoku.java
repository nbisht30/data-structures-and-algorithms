package leetcode.solved.categorized.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P36ValidSudoku {
    // MYSELF
    // Optimization 1: Use boolean array instead of sets. In earlier submissions I used set.
    // @TODO: Optimize
    public boolean isValidSudoku(char[][] board) {
        List<boolean[]> subBoxSets = fillBooleanList(3);
        List<boolean[]> colsSets = fillBooleanList(9);
        boolean[] row = new boolean[10];

        for(int i = 0; i < board.length; i++){
            row = new boolean[10];
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.') {
                    if(row[board[i][j] - 48]) {
                        return false;
                    }
                    else row[board[i][j] - 48] = true;

                    if(colsSets.get(j)[board[i][j] - 48]) {
                        return false;
                    }
                    else colsSets.get(j)[board[i][j] - 48] = true;

                    int subBoxIndex = (j / 3);
                    if(subBoxSets.get(subBoxIndex)[board[i][j] - 48]) {
                        return false;
                    }
                    else {
                        subBoxSets.get(subBoxIndex)[board[i][j] - 48] = true;
                    }
                }
            }
            if((i + 1) % 3 == 0) subBoxSets = fillBooleanList(3);
        }
        return true;
    }

    private List<boolean[]> fillBooleanList(int numSets){
        List<boolean[]> listOfSets = new ArrayList<>();
        while(numSets != 0){
            listOfSets.add(new boolean[10]);
            numSets--;
        }
        return listOfSets;
    }
}