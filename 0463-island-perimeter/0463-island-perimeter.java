class Solution {
    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 ||
            r >= grid.length || c >= grid[0].length) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == -1) {
            return 0;
        }

        grid[r][c] = -1;

        return dfs(grid, r + 1, c)
             + dfs(grid, r - 1, c)
             + dfs(grid, r, c + 1)
             + dfs(grid, r, c - 1);
    }
}