package leetcode.solved.categorized.graphs;

class P130SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int rows = board.length, cols = board[0].length;

        // For first and last rows
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[rows - 1][i] == 'O') dfs(board, rows - 1, i);
        }

        // For first and last columns
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }

    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = '#'; // replacement character(this also avoids reverse traversal from a node that we've already visited, as in above condition we have board[i][j] != 'O')

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

    }
}