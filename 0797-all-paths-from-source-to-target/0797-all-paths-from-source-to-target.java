class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(ans, path, graph, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, 
                    List<Integer> path, 
                    int[][] graph, int node) {
                        
        if (node == graph.length - 1) {
            ans.add(new ArrayList(path));
            return;
        }

        for (int element : graph[node]) {
            path.add(element);
            dfs(ans, path, graph, element);
            path.remove(path.size() - 1);
        }     
    }
}