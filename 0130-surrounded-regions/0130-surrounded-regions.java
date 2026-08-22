class Solution {
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[row-1][i] == 'O') {
                dfs(board, row-1, i);
            }
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col-1] == 'O') {
                dfs(board, i, col-1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int row = board.length;
        int col = board[0].length;

        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}