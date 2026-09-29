class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for (boolean room : visited) {
            if (!room)
                return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int src, boolean[] visited) {
        visited[src] = true;

        for (int room : rooms.get(src)) {
            if (!visited[room])
                dfs(rooms, room, visited);
        }
    }
}