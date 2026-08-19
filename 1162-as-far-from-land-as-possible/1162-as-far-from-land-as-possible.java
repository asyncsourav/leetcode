class Solution {
    public int maxDistance(int[][] grid) {

        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int[][] dirs = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        int distance = -1;

        // Multi-source BFS from all land cells.
        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0) {

                        grid[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance;
    }
}