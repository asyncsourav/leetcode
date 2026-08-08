class Solution {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>())
                 .add(new Pair(b, value));

            graph.computeIfAbsent(b, k -> new ArrayList<>())
                 .add(new Pair(a, 1.0 / value));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(start, end, 1.0, graph, new HashSet<>());
            }
        }

        return ans;
    }

    private double dfs(String curr, String target, double product,
                       Map<String, List<Pair>> graph,
                       Set<String> visited) {

        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Pair edge : graph.get(curr)) {
            if (!visited.contains(edge.node)) {
                double result = dfs(
                    edge.node,
                    target,
                    product * edge.value,
                    graph,
                    visited
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}