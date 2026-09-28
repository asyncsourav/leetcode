class Solution {

    private boolean dfs(List<List<Integer>> adj, int src, int dst, boolean[] visited) {
        if (src == dst)
            return true;

        if (visited[src])
            return false;

        visited[src] = true;

        for (int neighbor : adj.get(src)) {
            if (dfs(adj, neighbor, dst, visited))
                return true;
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int src, int dst) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj, src, dst, visited);
    }
}