class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(arr, d, i, dp));
        }

        return ans;
    }

    private int solve(int[] arr, int d, int i, int[] dp) {

        if (dp[i] != 0)
            return dp[i];

        dp[i] = 1;


        for (int j = i - 1; j >= 0 && j >= i - d; j--) {
            if (arr[i] <= arr[j])
                break;

            dp[i] = Math.max(dp[i], 1 + solve(arr, d, j, dp));
        }

        for (int j = i + 1; j < arr.length && j <= i + d; j++) {
            if (arr[i] <= arr[j])
                break;

            dp[i] = Math.max(dp[i], 1 + solve(arr, d, j, dp));
        }

        return dp[i];
    }
}