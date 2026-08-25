class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) 
            return -1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int group = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
                group++;
            }
        }

        return group - 1;
    }

    private void bfs(List<List<Integer>> adj, int node, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int x : adj.get(curr)) {
                
                if (!visited[x]) {
                    visited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }
}