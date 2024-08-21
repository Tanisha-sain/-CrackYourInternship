// The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. 
// The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. 
// If Matrix[i][j]=-1, it means there is no edge from i to j.
// Note : Modify the distances for every pair in-place.

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)Math.pow(10,9);
                }
            }
        }
        
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(i == j || i == k || j == k) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == (int)Math.pow(10,9)){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
