class Solution {
    public int findCircleNum(int[][] con) {
        
        int n = con.length;
        boolean[] vis = new boolean[n];

        int pro = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(con, i, vis);
                pro++;
            }
        }

        return pro;
    }

    private void dfs(int[][] con, int node, boolean[] vis) {
        vis[node] = true;

        for (int x = 0; x < con.length; x++) {
            if (con[node][x] == 1 && !vis[x]) {
                dfs(con, x, vis);
            }
        }
    }
}