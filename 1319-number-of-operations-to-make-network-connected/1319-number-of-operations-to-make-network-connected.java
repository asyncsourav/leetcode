class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1)
            return -1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += 1;
                dfs(graph, i, visited);
            }
        }

        return count - 1;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node])
            return;

        visited[node] = true;

        for (int x : graph.get(node)) {
            if (!visited[x]) 
                dfs(graph, x, visited);
        }
    }
}