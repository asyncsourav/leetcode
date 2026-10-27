class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0;
        int right = Math.min(m, n);
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == 0) {
                left = 1;
                continue;
            }

            boolean found = false;

            for (int i = mid; i <= m && !found; i++) {
                for (int j = mid; j <= n; j++) {

                    int sum = prefix[i][j]
                            - prefix[i - mid][j]
                            - prefix[i][j - mid]
                            + prefix[i - mid][j - mid];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}