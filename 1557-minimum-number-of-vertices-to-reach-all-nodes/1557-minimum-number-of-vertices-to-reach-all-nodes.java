class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int[] indegree = new int[n + 1];

        for (List<Integer> x : edges) {
            int el = x.get(1);
            indegree[el]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}