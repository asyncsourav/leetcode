class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum %2 != 0)
            return false;

        dp = new Boolean[nums.length][sum/2 + 1];
        return solve(nums, sum/2, 0);
    }

    private boolean solve(int[] nums, int sum, int idx) {

        if (sum == 0)
            return true;

        if (idx == nums.length)
            return false;

        if (dp[idx][sum] != null)
            return dp[idx][sum];

        boolean notTake = solve(nums, sum, idx + 1);
        boolean take = false;

        if (nums[idx] <= sum)
            take = solve(nums, sum - nums[idx], idx + 1);

        return dp[idx][sum] = take || notTake;
    }
}