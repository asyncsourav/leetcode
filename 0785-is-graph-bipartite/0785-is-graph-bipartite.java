class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] arr = new int[n];
        // 0 -> uncolored, 1 -> color1, -1 -> color2

        for (int i = 0; i < n; i++) {

            if (arr[i] != 0)
                continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            arr[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int num : graph[node]) {
                    
                    if (arr[num] == 0) {
                        arr[num] = -arr[node];
                        queue.offer(num);
                    }

                    else if (arr[num] == arr[node])
                        return false;
                }
            }
        }

        return true;
    }
}