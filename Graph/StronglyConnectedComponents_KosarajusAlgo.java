// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.

class Solution
{
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack, int i){
        vis[i] = true;
        for(Integer n : adj.get(i)){
            if(!vis[n]){
                dfs(adj, vis, stack, n);
            }
        }
        stack.push(i);
    }
    void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer n : adj.get(node)){
            if(!vis[n]){
                dfs2(n, vis, adj);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                dfs(adj, vis, stack, i);
            }
        }
        
        ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
        for(int i = 0; i<V; i++){
            reversed.add(new ArrayList<>());
        }
        for(int i= 0; i<V; i++){
            vis[i] = false;
            for(Integer n : adj.get(i)){
                reversed.get(n).add(i);
            }
        }
        int scc = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!vis[node]){
                scc++;
                dfs2(node, vis, reversed);
            }
        }
        return scc;
    }
}
