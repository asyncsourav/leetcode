class Solution {
    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int cost = edge[1];

                if (!visited[nextCity]) {

                    visited[nextCity] = true;
                    count += cost;
                    queue.offer(nextCity);
                }
            }
        }

        return count;
    }
     
}