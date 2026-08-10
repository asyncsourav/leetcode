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

        return dfs(start, map, visited);
    }

    private int dfs(Employee start, HashMap<Integer, Employee> map, boolean[] visited) {

        if (visited[start.id]) 
            return 0;

        visited[start.id] = true;
        int sum = start.importance;

        for (int sid : start.subordinates) {
            sum += dfs(map.get(sid), map, visited);
        } 

        return sum;
    }
}