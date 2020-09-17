package leetcode.solved.categorized.arrays.matrices;

class P289GameOfLife {
    public void gameOfLife(int[][] board) {
        // -1 -> If cell is now dead but was live originally
        // 2 -> If cell is now live but was dead originally
        for(int i = 0; i < board.length; i++){ // Rows Scanner
            for(int j = 0; j < board[i].length; j++){ // Columms Scanner
                
                int liveNbrsCnt = 0;
                
                // Top cell
                if(i - 1 >= 0 && isLiveNbr(board[i - 1][j])) liveNbrsCnt++;

                // Bottom cell
                if(i + 1 < board.length && isLiveNbr(board[i + 1][j])) liveNbrsCnt++;
                
                // Right cell
                if(j + 1 < board[i].length && isLiveNbr(board[i][j + 1])) liveNbrsCnt++;
                
                // Left cell
                if(j - 1 >= 0 && isLiveNbr(board[i][j - 1])) liveNbrsCnt++;
                
                // Top left cell
                if(i - 1 >= 0 && j - 1 >= 0 && isLiveNbr(board[i - 1][j - 1])) liveNbrsCnt++;
                
                // Top right cell
                if(i - 1 >=0 && j + 1 < board[i].length && isLiveNbr(board[i - 1][j + 1])) liveNbrsCnt++;
                
                // Bottom left cell
                if(i + 1 < board.length && j - 1 >= 0 && isLiveNbr(board[i + 1][j - 1])) liveNbrsCnt++;
                
                // Bottom right cell
                if(i + 1 < board.length && j + 1 < board[i].length && isLiveNbr(board[i + 1][j + 1])) liveNbrsCnt++;

                if(isLiveNbr(board[i][j])){
                    if(liveNbrsCnt < 2 || liveNbrsCnt > 3) board[i][j] = -1;
                }else if(liveNbrsCnt == 3) board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1 || board[i][j] == 2) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
        
    }
    
    boolean isLiveNbr(int val){
        if(val == 0 || val == 2) return false;
        return true;
    }
}