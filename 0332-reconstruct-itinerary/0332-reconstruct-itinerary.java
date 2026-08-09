class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.putIfAbsent(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }

        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans);

        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String airport,
                     Map<String, PriorityQueue<String>> adj,
                     List<String> ans) {

        PriorityQueue<String> destinations = adj.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, adj, ans);
        }

        ans.add(airport);
    }
}