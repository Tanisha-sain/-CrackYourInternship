// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
// Return the size of the largest island in grid after applying this operation.
// An island is a 4-directionally connected group of 1s.


class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                int dr[] = {-1,0,1,0};
                int dc[] = {0,1,0,-1};
                for(int ind = 0; ind < 4; ind++){
                    int nr = row + dr[ind];
                    int nc = col + dc[ind];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        int node = row*n + col;
                        int adjNode = nr*n + nc;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }

        int mx = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;
                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};
                HashSet<Integer> comp = new HashSet<>();
                for(int ind = 0; ind < 4; ind++){
                    int nr = row + dr[ind];
                    int nc = col + dc[ind];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                        if(grid[nr][nc] == 1){
                            comp.add(ds.findUPar(nr*n + nc));
                        }
                    }
                }

                int size = 0;
                for(Integer parents : comp){
                    size += ds.size.get(parents);
                }
                mx = Math.max(mx, size+1);
            }
        }
        for(int cell = 0; cell < n*n; cell++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cell)));
        }
        return mx;
    }
}
