class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            } 
        }
        
        return topo;
    }
}