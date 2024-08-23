// You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style
// starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
// You start on square 1 of the board. In each move, starting from square curr, do the following:
// Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
// This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations,
// regardless of the size of the board.
// If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
// The game ends when you reach the square n2.
// A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. 
// Squares 1 and n2 are not the starting points of any snake or ladder.
// Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake 
// or ladder, you do not follow the subsequent snake or ladder.
// For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. 
// You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
// Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

class Solution {
    public int[] findCoordinates(int curr, int n){
        int r = n - (curr-1)/n - 1;
        int c = (curr-1)%n;
        if(r%2 == n%2){
            return new int[]{r, n-1-c};
        }
        return new int[]{r,c};

    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        queue.add(1);
        vis[n-1][0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int x = queue.poll();
                if(x == n*n) return steps;

                for(int k = 1; k<=6; k++){
                    if(k + x > n*n) break;
                    int[] pos = findCoordinates(x+k, n);
                    int r = pos[0];
                    int c = pos[1];
                    if(vis[r][c]) continue;
                    vis[r][c] = true;
                    if(board[r][c] == -1){
                        queue.add(x+k);
                    }else{
                        queue.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
