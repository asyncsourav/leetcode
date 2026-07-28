

// first check the number of edge is less than the total number of connections
// then check the number of groups (after connections) - and return the number of groups - 1 

class Solution {
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n -1)
            return -1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }        

        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int group = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                group++;
                bfs(adj, visited, i);
            }
        }

        return group - 1;
    }

    private void bfs(List<List<Integer>> adj, boolean[] visited, int node) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbor : adj.get(current)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}