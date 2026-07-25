class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    fresh += 1;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (fresh == 0)
            return 0;

        int minute = 0;
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        grid[nr][nc] == 1) {
                        
                        queue.add(new int[]{nr, nc});
                        fresh -= 1;
                        grid[nr][nc] = 2;
                    }
                }
            }
            minute += 1;
        }

        return fresh == 0 ? minute : -1;
    }
}