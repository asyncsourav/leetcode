/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        Employee start = map.get(id);
        boolean[] visited = new boolean[2001];
        
        return dfs(start, visited, map);
    }

    private int dfs(Employee node, boolean[] visited, HashMap<Integer, Employee> map) {
        
        if (visited[node.id])
            return 0;

        visited[node.id] = true;
        int ans = node.importance;

        for (Integer SubId : node.subordinates) {
            ans += dfs(map.get(SubId), visited, map);
        }

        return ans;
    }
}