// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
// The same letter cell may not be used more than once.

class Solution {
    boolean helper(int curr, int i, int j, char[][] board, String word, boolean[][] visited){
        if(curr == word.length()-1) return true;

        if(i-1 >= 0 && board[i-1][j] == word.charAt(curr+1) && !visited[i-1][j]){
            visited[i-1][j] = true;
            boolean temp = helper(curr+1, i-1, j, board, word, visited);
            if(temp) return true;
            visited[i-1][j] = false;
        }
        if(j-1 >= 0 && board[i][j-1] == word.charAt(curr+1) && !visited[i][j-1]){
            visited[i][j-1] = true;
            boolean temp = helper(curr+1, i, j-1, board, word, visited);
            if(temp) return true;
            visited[i][j-1] = false;
        }
        if(i+1 < board.length && board[i+1][j] == word.charAt(curr+1) && !visited[i+1][j]){
            visited[i+1][j] = true;
            boolean temp = helper(curr+1, i+1, j, board, word, visited);
            if(temp) return true;
            visited[i+1][j] = false;
        }
        if(j+1 < board[0].length && board[i][j+1] == word.charAt(curr+1) && !visited[i][j+1]){
            visited[i][j+1] = true;
            boolean temp = helper(curr+1, i, j+1, board, word, visited);
            if(temp) return true;
            visited[i][j+1] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    vis[i][j] = true;
                    boolean temp = helper(0, i, j, board, word, vis);
                    if(temp) return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}
