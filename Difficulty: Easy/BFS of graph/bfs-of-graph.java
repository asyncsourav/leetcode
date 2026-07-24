class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            
            for (int neighbor : adj.get(node)) {
                
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return ans;
    }
}