class Solution {
    public int[] findOrder(int n, int[][] pre) {
        
        int[] ind = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

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
                queue.add(i);
            }
        }

        int[] ans = new int[n];
        int idx = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            ans[idx++] = curr;

            for (int num : adj.get(curr)) {
                ind[num]--;

                if (ind[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        return (idx == n) ? ans : new int[0];
    }
}