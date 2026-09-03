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

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int start = jobs[i][0];
            int end = jobs[i][1];
            int currentProfit = jobs[i][2];

            // Find the first job whose start time >= current job's end time
            int nextJob = findNextJob(jobs, end, i + 1);

            int take = currentProfit;

            if (nextJob < n) {
                take += dp[nextJob];
            }

            // Option 1: take current job
            // Option 2: skip current job
            int skip = (i + 1 < n) ? dp[i + 1] : 0;

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    private int findNextJob(int[][] jobs, int endTime, int left) {

        int right = jobs.length - 1;
        int answer = jobs.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (jobs[mid][0] >= endTime) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}