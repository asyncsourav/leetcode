class Solution {

    private int dfs(List<List<Integer>> graph, int src, boolean[] visited) {
        if (visited[src])
            return 0;
        
        visited[src] = true;
        int count = 1;

        for (int x : graph.get(src)) {
            if (!visited[x])
                count += dfs(graph, x, visited);
        }

        return count;
    }

    public long countPairs(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int unvisited = n;
        long ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                int elements = dfs(graph, i, visited);
                unvisited -= elements;
                ans += (long) unvisited * elements;
            }
        }

        return ans;
    }
}