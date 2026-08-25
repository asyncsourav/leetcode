class Solution {
    public boolean canFinish(int n, int[][] pre) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] ind = new int[n]; 

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] num : pre) {
            int u = num[0];
            int v = num[1];

            adj.get(v).add(u);
            ind[u]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int nei : adj.get(curr)) {
                ind[nei]--;

                if (ind[nei] == 0)
                    queue.offer(nei);
            }
        }

        return count == n;
    }
}