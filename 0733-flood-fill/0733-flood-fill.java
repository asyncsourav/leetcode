class Solution {
    public int[][] floodFill(int[][] img, int sr, int sc, int col) {
        
        int or = img[sr][sc];

        if (or == col) 
            return img;

        dfs(img, sr, sc, col, or);

        return img;
    }

    private void dfs(int[][] img, int sr, int sc, int col, int or) {

        if (sr >= img.length ||
            sc >= img[0].length ||
            sr < 0 || sc < 0 ||
            img[sr][sc] != or) {
            
            return;
        }

        img[sr][sc] = col;

        dfs(img, sr + 1, sc, col, or);
        dfs(img, sr - 1, sc, col, or);
        dfs(img, sr, sc + 1, col, or);
        dfs(img, sr, sc - 1, col, or);
    } 
}