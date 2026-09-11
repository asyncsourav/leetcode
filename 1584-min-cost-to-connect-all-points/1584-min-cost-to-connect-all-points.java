class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int cost = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(new int[]{j, cost});
                adj.get(j).add(new int[]{i, cost});
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        boolean[] visited = new boolean[n];
        int totalCost = 0;

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int edgeCost = neighbor[1];

                if (!visited[nextNode]) {
                    pq.offer(new int[]{nextNode, edgeCost});
                }
            }
        }

        return totalCost;
    }
}