class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms, vis, 0);

        for (boolean r : vis) {
            if (!r) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] vis, int node) {

        vis[node] = true;

        for (int room : rooms.get(node)) {
            if (!vis[room]) {
                dfs(rooms, vis, room);
            }
        }
    }
}