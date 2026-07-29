class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


        int fresh = 0;
        int minute = 0;

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
            return minute;

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
                        
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        fresh -= 1;
                    }
                }
            }
            minute += 1;
        }

        return fresh == 0 ? minute : -1;
    }
}