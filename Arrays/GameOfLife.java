// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
// Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
// - Any live cell with fewer than two live neighbors dies as if caused by under-population.
// - Any live cell with two or three live neighbors lives on to the next generation.
// - Any live cell with more than three live neighbors dies, as if by over-population.
// - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur 
// simultaneously. Given the current state of the m x n grid board, return the next state.


class Solution {
    int findLives(int i, int j, int[][] board){
        int n = board.length, m = board[0].length;
        int live = 0;
        if(i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 1) live++;
        if(i-1 >= 0 && board[i-1][j] == 1) live++;
        if(i-1 >= 0 && j+1 < m && board[i-1][j+1] == 1) live++;
        if(j-1 >= 0 && board[i][j-1] == 1) live++;
        if(j+1 < m && board[i][j+1] == 1) live++;
        if(i+1 < n && j-1 >= 0 && board[i+1][j-1] == 1) live++;
        if(i+1 < n && board[i+1][j] == 1) live++;
        if(i+1 < n && j+1 < m && board[i+1][j+1] == 1) live++;
        return live;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] clone = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                clone[i][j] = board[i][j];
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int live = findLives(i,j,clone);
                if(board[i][j] == 1){
                    if(live != 2 && live != 3) board[i][j] = 0;
                }else{
                    if(live == 3) board[i][j] = 1;
                }
            }
        }
    }
}
