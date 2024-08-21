// Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

class Solution
{
    boolean check(int V, int i, int[] color, ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        color[i] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int n : adj.get(node)){
                if(color[n] == -1){
                    color[n] = 1 - color[node];
                    queue.add(n);
                }else if(color[n] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i<V; i++){
            if(color[i] == -1){
                if(!check(V, i, color, adj)) return false;
            }
        }
        
        return true;
    }
}
