// You are given an m x n integer array grid where grid[i][j] could be:
// - 1 representing the starting square. There is exactly one starting square.
// - 2 representing the ending square. There is exactly one ending square.
// - 0 representing empty squares we can walk over.
// - -1 representing obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.


class Solution {
    int dfs(int n, int m, int[][] grid, int x, int y, int zeros){
        if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == -1) return 0;

        if(grid[x][y] == 2){
            return (zeros == -1) ? 1 : 0;
        }

        grid[x][y] = -1;
        zeros--;

        int paths = dfs(n,m,grid,x+1,y,zeros) + dfs(n,m,grid,x-1,y,zeros) + dfs(n,m,grid,x,y+1,zeros) + dfs(n,m,grid,x,y-1, zeros);

        grid[x][y] = 0;
        zeros++;

        return paths;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int zeros = 0, sx = 0, sy = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0) zeros++;
                else if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }

        return dfs(n, m, grid, sx, sy, zeros);
    }
}
