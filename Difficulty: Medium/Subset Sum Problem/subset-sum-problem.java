class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int target = sum; target >= num; target--) {
                dp[target] = dp[target] || dp[target - num];
            }
        }

        return dp[sum];
    }
}