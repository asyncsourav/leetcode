class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int ma = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1)
                    ma = Math.max(ma, dfs(grid, i, j));
            }
        }

        return ma;
    }

    private int dfs(int[][] grid, int i, int j) {

        if (i >= grid.length ||
            j >= grid[0].length ||
            i < 0 || j < 0 ||
            grid[i][j] != 1) {

            return 0;
        }

        grid[i][j] = 0;
        
        return 1 + 
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }
}