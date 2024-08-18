// Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors
// such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the
// assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

class solve {
    boolean isSafe(int node, HashMap<Integer, ArrayList<Integer>> map, int[] color, int n, int col){
        ArrayList<Integer> no = map.get(node);
        for(int i : no){
            if(color[i] == col) return false;
        }
        return true;
    }
    boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int curr, int[] color, int n, int m){
        if(curr == n) return true;
        
        for(int i = 1; i<=m; i++){
            if(isSafe(curr, map, color, n, i)){
                color[curr] = i;
                if(dfs(map, curr+1, color, n, m)) return true;
                color[curr] = 0;
            }
        }
        
        return false;
    }
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<Integer>());
            for(int j = 0; j<n; j++){
                if(graph[i][j]){
                    map.get(i).add(j);
                }
            }
        }
        
        int[] color = new int[n];
        
        return dfs(map, 0, color, n, m);
    }
}
