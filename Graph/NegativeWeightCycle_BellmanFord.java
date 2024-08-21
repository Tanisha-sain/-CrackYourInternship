// Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, 
// the task is to check if it contains a negative weight cycle or not.
// Note: edges[i] is defined as u, v and weight.

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e8));
        dist[0] = 0;
        
        for(int i = 1; i<n; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(dist[u] + wt < dist[v]){
                return 1;
            }
        }
        return 0;
        
    }
    
}
