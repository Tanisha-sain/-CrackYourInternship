// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
// Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph
// starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes 
// directly or indirectly connected from Node 0 in consideration.

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(!vis[curr]){
                ans.add(curr);
                vis[curr] = true;
                
                for(int i = 0; i<adj.get(curr).size(); i++){
                    queue.offer(adj.get(curr).get(i));
                }
            }
        }
        return ans;
    }
}
