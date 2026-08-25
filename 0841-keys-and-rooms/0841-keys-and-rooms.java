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

        if (vis[node]) {
            return;
        }

        vis[node] = true;

        for (int room : rooms.get(node)) {
            dfs(rooms, vis, room);
        }
    }
}