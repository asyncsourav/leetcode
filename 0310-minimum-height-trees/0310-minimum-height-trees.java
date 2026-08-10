class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] num : edges) {
            adj.get(num[0]).add(num[1]);
            adj.get(num[1]).add(num[0]);
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

        int remain = n;

        while (remain > 2) {
            int size = queue.size();
            remain = remain - size;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int num : adj.get(node)) {
                    degree[num]--;

                    if (degree[num] == 1)
                        queue.offer(num);
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