// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

class Solution {
    int n = 0;
    int m = 0;
    void dfs(char[][] grid, int i, int j){
        if(i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == '2' || grid[i][j] == '0') return;
        grid[i][j] = '2';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
