// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

class Solution {
    boolean dfs(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(dfs(n, vis, pathVis, adj)) return true;
            }else if(pathVis[n]){
                return true;
            }
        }
        
        pathVis[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj)) return true;
            }
        }
        return false;
    }
}
