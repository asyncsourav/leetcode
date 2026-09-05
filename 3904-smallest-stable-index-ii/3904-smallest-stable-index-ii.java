class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // suffixMin[i] = minimum value from i to n - 1
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Maximum from nums[0] to nums[i]
        int maxLeft = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);

            int minRight = suffixMin[i];

            if (maxLeft - minRight <= k) {
                return i;
            }
        }

        return -1;
    }
}