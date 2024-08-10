// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color 
// as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the 
// color of all of the aforementioned pixels with color.
// Return the modified image after performing the flood fill.

class Solution {
    class Pair{
        int row;
        int col;
        Pair(int r, int c){
            row = r;
            col = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int init = image[sr][sc];

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr,sc));

        boolean[][] vis = new boolean[n][m];
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int i = curr.row;
            int j = curr.col;
            image[i][j] = color;
            if(!vis[i][j]){
                vis[i][j] = true;
                if(i+1 < n && image[i+1][j] == init && !vis[i+1][j]) queue.offer(new Pair(i+1, j));
                if(i-1 >= 0 && image[i-1][j] == init && !vis[i-1][j]) queue.offer(new Pair(i-1,j));
                if(j+1 < m && image[i][j+1] == init && !vis[i][j+1]) queue.offer(new Pair(i, j+1));
                if(j-1 >= 0 && image[i][j-1] == init && !vis[i][j-1]) queue.offer(new Pair(i, j-1));
            }  
        }
        return image;
    }
}
