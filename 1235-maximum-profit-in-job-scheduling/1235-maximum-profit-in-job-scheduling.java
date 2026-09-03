
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // dp[i] = maximum profit we can earn starting from job i
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int take = jobs[i][2];

            // Find the next non-overlapping job
            for (int j = i + 1; j < n; j++) {

                if (jobs[j][0] >= jobs[i][1]) {
                    take += dp[j];
                    break;
                }
            }

            // Skip current job
            int skip = 0;

            if (i + 1 < n) {
                skip = dp[i + 1];
            }

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}