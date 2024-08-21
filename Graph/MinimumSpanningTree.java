// Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges 
// in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector
// containing vector of integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second 
// integer denoting the weight of the edge.

class Solution {
    static class Pair{
        int node;
        int dist;
        Pair(int n, int d){
            node = n;
            dist = d;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.dist - y.dist);
        boolean[] vis = new boolean[V];
        
        pq.add(new Pair(0,0));
        int sum = 0;
        while(pq.size() > 0){
            Pair curr = pq.poll();
            int wt = curr.dist;
            int node = curr.node;
            if(!vis[node]){
                vis[node] = true;
                sum += wt;
                
                for(int i = 0; i<adj.get(node).size(); i++){
                    int n = adj.get(node).get(i)[0];
                    int adjwt = adj.get(node).get(i)[1];
                    
                    if(!vis[n]){
                        pq.add(new Pair(n, adjwt));
                    }
                }
            }
        }
        
        return sum;
    }
    
}
