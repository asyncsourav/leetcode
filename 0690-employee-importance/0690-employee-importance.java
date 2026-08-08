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

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        Employee start = map.get(id);
        boolean[] visited = new boolean[2001];

        return dfs(start, visited, map);
    }

    private int dfs(Employee emp, boolean[] visited,
                     Map<Integer, Employee> map) {

        if (visited[emp.id]) 
            return 0;

        visited[emp.id] = true;
        int ans = emp.importance;

        for (Integer subId : emp.subordinates) {
            ans += dfs(map.get(subId), visited, map);
        }

        return ans;
    }
}