class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += 1;
                dfs(isConnected, i, visited);
            }
        }

        return count;
    }

    private void dfs(int[][] graph, int node, boolean[] vis) {
        if (vis[node])
            return;

        vis[node] = true;

        for (int x = 0; x < graph.length; x++) {
            if (graph[node][x] == 1 && !vis[x])
                dfs(graph, x, vis);
        }
    }
}