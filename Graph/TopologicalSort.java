// Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j
// such that there is a directed edge from vertex i to vertex j, with  V  vertices and E  edges,
// your task is to find any valid topological sorting of the graph.
// In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.


class Solution
{
    static void dfs(int curr, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        for(int i = 0; i<adj.get(curr).size(); i++){
            if(!vis[adj.get(curr).get(i)]){
                dfs(adj.get(curr).get(i), vis, stack, adj);
            }
        }
        stack.push(curr);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, stack, adj);
            }
        }
        
        int[] ans = new int[V];
        int i = 0;
        
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
