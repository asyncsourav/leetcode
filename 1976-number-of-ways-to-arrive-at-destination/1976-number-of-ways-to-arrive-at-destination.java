class Solution {

    static class Pair implements Comparable<Pair> {
        int node;
        long distance;

        Pair(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair that) {
            return Long.compare(this.distance, that.distance);
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);

        long[] ways = new long[n];

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int node = curr.node;
            long currDist = curr.distance;

            if (currDist > distance[node]) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;
                long edgeWeight = neighbor.distance;
                long newDist = currDist + edgeWeight;

                if (newDist < distance[nextNode]) {

                    distance[nextNode] = newDist;
                    ways[nextNode] = ways[node];

                    pq.offer(new Pair(nextNode, newDist));
                }

                else if (newDist == distance[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}