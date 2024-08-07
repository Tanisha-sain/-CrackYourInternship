// You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
// Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    void dfs(int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] vis){
        if(vis[curr]) return;
        vis[curr] = true;
        ans.add(curr);
        
        for(int i = 0; i<adj.get(curr).size(); i++){
            dfs(adj.get(curr).get(i), adj, ans, vis);
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        dfs(0, adj, ans, vis);
        return ans;
    }
}
