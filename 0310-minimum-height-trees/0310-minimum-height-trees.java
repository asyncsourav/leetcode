class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (n == 1) return List.of(0);
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) 
                queue.offer(i);
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;

            while (size-- > 0) {
                int node = queue.poll();

                for (int nei : adj.get(node)) {
                    degree[nei]--;

                    if (degree[nei] == 1)
                        queue.offer(nei);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;
    }
}