class Solution {
    public int minimumCost(int[] nums, int k) {
        final long MOD = 1_000_000_007L;

        long resources = k;
        long operations = 0;
        long cost = 0;

        for (int num : nums) {
            if (resources < num) {
                long need = (num - resources + k - 1L) / k;

                long add1 = (need % MOD) * (operations % MOD) % MOD;

                long a = need;
                long b = need + 1;
                if ((a & 1) == 0)
                    a /= 2;
                else
                    b /= 2;

                long add2 = (a % MOD) * (b % MOD) % MOD;

                cost = (cost + add1 + add2) % MOD;

                operations += need;
                resources += need * (long) k;
            }

            resources -= num;
        }

        return (int) cost;
    }
}