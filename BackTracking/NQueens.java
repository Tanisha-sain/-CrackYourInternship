// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate 
// a queen and an empty space, respectively.

class Solution {
    boolean isSafe(char[][] board, int row, int col, int n){
        int duprow = row;
        int dupcol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        col = dupcol;
        row = duprow;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        col = dupcol;
        row = duprow;
        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    void solve(char[][] board, int col, List<List<String>> res, int n){
        if(col == n){
            List<String> temp = new ArrayList<>(n);
            for(char[] row : board){
                StringBuilder sb = new StringBuilder();
                sb.append(row);
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }

        for(int row = 0; row<n; row++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                solve(board,col+1,res,n);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] temp : board){
            Arrays.fill(temp, '.');
        }
        solve(board, 0, res, n);
        return res;
    }
}
