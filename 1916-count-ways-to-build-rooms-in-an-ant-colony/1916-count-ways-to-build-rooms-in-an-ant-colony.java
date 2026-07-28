class Solution {

    private static final int MOD = 1_000_000_007;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(prevRoom[i]).add(i);
        }

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        Pair ans = dfs(0, tree, fact, invFact);

        return (int) ans.ways;
    }

    static class Pair {
        int size;
        long ways;

        Pair(int size, long ways) {
            this.size = size;
            this.ways = ways;
        }
    }

    private Pair dfs(int node, List<List<Integer>> tree,
                     long[] fact, long[] invFact) {

        int totalSize = 1;
        long totalWays = 1;

        for (int child : tree.get(node)) {

            Pair curr = dfs(child, tree, fact, invFact);

            totalWays = totalWays * curr.ways % MOD;

            totalWays = totalWays * invFact[curr.size] % MOD;

            totalSize += curr.size;
        }

        totalWays = totalWays * fact[totalSize - 1] % MOD;

        return new Pair(totalSize, totalWays);
    }

    private long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }
}