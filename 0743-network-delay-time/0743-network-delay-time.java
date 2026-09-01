class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] time = dijkstra(src - 1, n, adj);
        int res = Integer.MIN_VALUE;

        for (int t : time) {
            if (t == Integer.MAX_VALUE)
                return -1;

            res = Math.max(t, res);
        }

        return res;
    }


    private int[] dijkstra(int src, int n, List<List<int[]>> adj) {

        // pair -> (node, time) -> increasing order of time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                public int compare(int[] p1, int[] p2) {
                    return p1[1] - p2[1];
                }
            }
        );

        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int u = curr[0];
            int d = curr[1];

            if (d > time[u])
                continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                if (time[u] + w < time[v]) {
                    time[v] = time[u] + w;
                    pq.offer(new int[]{v, time[v]});
                }
            }
        }
        return time;
    }
}