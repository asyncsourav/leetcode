class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != '.') {
                    if (!isValid(board[i][j], board, i, j, m, n)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValid(char num, char[][] board, int row, int col, int m, int n) {

        for (int i = row + 1; i < m; i++) {
            if (board[i][col] == num)
                return false;
        }

        for (int i = col + 1; i < n; i++) {
            if (board[row][i] == num)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {

                if (i == row && j <= col)
                    continue;

                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}