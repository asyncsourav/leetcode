class Solution {
    public long maxPairStrength(int[] nums) {

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                long a = nums[i];
                long b = nums[j];
                long g = gcd(a, b);

                ans = Math.max(ans, (a * b) / (g * g));
            }
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}