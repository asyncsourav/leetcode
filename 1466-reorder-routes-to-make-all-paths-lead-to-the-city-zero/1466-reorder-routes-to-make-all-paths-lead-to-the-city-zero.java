class Solution {
    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> graph = buildGraph(n, connections);
        boolean[] visited = new boolean[n];
        return dfs(graph, 0, visited);
    }

    static List<List<int[]>> buildGraph(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : connections) {
            int from = road[0];
            int to = road[1];

            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        return graph;
    }

    static int dfs(List<List<int[]>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] edge : graph.get(node)) {
            int next = edge[0];
            int cost = edge[1];

            if (!visited[next]) {
                count += cost;
                count += dfs(graph, next, visited);
            }
        }

        return count;
    }
}