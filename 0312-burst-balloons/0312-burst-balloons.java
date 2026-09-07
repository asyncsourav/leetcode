class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        // Add virtual balloons with value 1 at both ends
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[left][right] = maximum coins obtainable
        // by bursting balloons between left and right
        int[][] dp = new int[n + 2][n + 2];

        // Length is the distance between left and right
        for (int len = 2; len < n + 2; len++) {
            for (int left = 0; left + len < n + 2; left++) {

                int right = left + len;
                
                for (int k = left + 1; k < right; k++) {
                    int coins = arr[left] * arr[k] * arr[right]
                              + dp[left][k]
                              + dp[k][right];

                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}