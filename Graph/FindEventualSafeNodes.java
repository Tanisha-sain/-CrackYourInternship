// There is a directed graph of n nodes with each node labeled from 0 to n - 1.
// The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array 
// of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
// A node is a terminal node if there are no outgoing edges. A node is a safe node 
// if every possible path starting from that node leads to a terminal node (or another safe node).
// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

class Solution {
    boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] path, boolean[] check){
        vis[node] = true;
        path[node] = true;
        check[node] = false;
        for(int n : graph[node]){
            if(!vis[n]){
                if(dfs(n, graph, vis, path, check)) return true;
            }else if(path[n]){
                return true;
            }
        }
        check[node] = true;
        path[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        boolean[] check = new boolean[v];
        for(int i = 0; i<v; i++){
            if(!vis[i]){
                dfs(i, graph, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(check[i]) safeNodes.add(i);
        }
        return safeNodes;
    }
}
