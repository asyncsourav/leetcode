class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(image, sr, sc, color, original);
        return image;
    }

    private void dfs(int[][] img, int sr, int sc, int color, int original) {

        if (sr < 0 || sc < 0 ||
            sr >= img.length ||  
            sc >= img[0].length ||
            img[sr][sc] != original) {

            return;
        }

        img[sr][sc] = color;

        dfs(img, sr + 1, sc, color, original);
        dfs(img, sr - 1, sc, color, original);
        dfs(img, sr, sc + 1, color, original);
        dfs(img, sr, sc - 1, color, original);
    }
}