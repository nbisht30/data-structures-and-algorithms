package leetcode.categorized.graphs.dfs;

class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(i, j, 0, board, visited, word)) return true;
            }
        }
        
        return false;
    }
    
    boolean dfs(int i, int j, int index, char[][] board, boolean[][] visited, String word){
        if(index == word.length()) return true;
        
        if(i < 0 || i >= board.length ||
           j < 0 || j >= board[i].length ||
           visited[i][j] || board[i][j] != word.charAt(index)) return false;
        
        visited[i][j] = true;
        
        if(dfs(i + 1, j, index + 1, board, visited, word) || 
           dfs(i - 1, j, index + 1, board, visited, word) ||
           dfs(i, j + 1, index + 1, board, visited, word) || 
           dfs(i, j - 1, index + 1, board, visited, word)) return true;
        
        visited[i][j] = false;
        
        return false;
    }
}