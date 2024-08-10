// Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cells have fresh oranges
// 2 : Cells have rotten oranges
// We have to determine what is the earliest time after which all the oranges are rotten.A rotten orange at 
// index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 


class Solution{
    class Pair{
        int row;
        int col;
        int time;
        
        Pair(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid){
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int cntFresh = 0;
        int cntRotten = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j,0));
                    cntRotten++;
                }else if(grid[i][j] == 1) cntFresh++;
            }
        }
        
        int totalVis = 0;
        int maxTime = 0;
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int i = curr.row;
            int j = curr.col;
            int t = curr.time;
            // System.out.println(i + " " + j + " " + t);
            if(!vis[i][j]){
                vis[i][j] = true;
                totalVis++;
                maxTime = (t > maxTime) ? t : maxTime;
                if(i+1 < n && grid[i+1][j] == 1 && !vis[i+1][j]) queue.offer(new Pair(i+1, j, t+1));
                if(j+1 < m && grid[i][j+1] == 1 && !vis[i][j+1]) queue.offer(new Pair(i, j+1, t+1));
                if(i-1 >= 0 && grid[i-1][j] == 1 && !vis[i-1][j]) queue.offer(new Pair(i-1, j, t+1));
                if(j-1 >= 0 && grid[i][j-1] == 1 && !vis[i][j-1]) queue.offer(new Pair(i, j-1, t+1));
            }
        }
        if(totalVis != cntFresh + cntRotten) return -1;
        return maxTime;
        
    }
}
