class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        boolean[][] board = new boolean[8][8];

        // Mark queen positions
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> ans = new ArrayList<>();

        int x = king[0];
        int y = king[1];

        // Left
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j]) {
                ans.add(Arrays.asList(x, j));
                break;
            }
        }

        // Right
        for (int j = y + 1; j < 8; j++) {
            if (board[x][j]) {
                ans.add(Arrays.asList(x, j));
                break;
            }
        }

        // Up
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y]) {
                ans.add(Arrays.asList(i, y));
                break;
            }
        }

        // Down
        for (int i = x + 1; i < 8; i++) {
            if (board[i][y]) {
                ans.add(Arrays.asList(i, y));
                break;
            }
        }

        // Up-Left
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                ans.add(Arrays.asList(i, j));
                break;
            }
        }

        // Up-Right
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j]) {
                ans.add(Arrays.asList(i, j));
                break;
            }
        }

        // Down-Left
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (board[i][j]) {
                ans.add(Arrays.asList(i, j));
                break;
            }
        }

        // Down-Right
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (board[i][j]) {
                ans.add(Arrays.asList(i, j));
                break;
            }
        }

        return ans;
    }
}