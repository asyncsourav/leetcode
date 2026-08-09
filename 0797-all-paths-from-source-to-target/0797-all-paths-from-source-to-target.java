class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        backtrack(graph, ans, path, 0);
        return ans;
    }

    private void backtrack(int[][] graph, 
                            List<List<Integer>> ans,
                            List<Integer> path,
                            int node) {
        
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int num : graph[node]) {
            path.add(num);
            backtrack(graph, ans, path, num);
            path.remove(path.size() - 1);
        }
    }
}