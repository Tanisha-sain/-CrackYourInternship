// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        for(int i = 0; i<n; i++){
            int[] curr = new int[m];
            for(int j = 0; j<m; j++){
                if(i == 0 && j == 0) curr[j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    int left = grid[i][j];
                    up += (i <= 0) ? (int)Math.pow(10,9) : prev[j];
                    left += (j <= 0) ? (int)Math.pow(10,9) : curr[j-1];
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
}
