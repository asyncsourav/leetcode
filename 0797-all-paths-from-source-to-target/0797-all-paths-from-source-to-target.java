class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        backtrack(ans, path, 0, graph);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans,
                            List<Integer> path,
                            int node, int[][] graph) {
        
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int num : graph[node]) {
            path.add(num);
            backtrack(ans, path, num, graph);
            path.remove(path.size() - 1);
        }
    }
}