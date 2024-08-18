// Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. 
// Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

class Solution {
    boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(dfs(n, node, vis, adj)) return true;
            }else if(n != parent) return true;
        }
        
        return false;
        
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}
