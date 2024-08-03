// Given a binary tree and an integer k, the task is to count the number of paths in the tree such that the sum of the nodes in each path equals k. 
// A path can start from any node and end at any node and must be downward only.

class Solution {
    void solve(Node root, int k, List<Integer> path, int[] count){
        if(root == null) return;
        path.add(root.data);
        
        solve(root.left, k, path, count);
        solve(root.right, k, path, count);
        
        int size = path.size();
        int sum = 0;
        for(int i = size-1; i>=0; i--){
            sum += path.get(i);
            if(sum == k) count[0]++;
        }
        path.remove(path.size()-1);
    }
    public int sumK(Node root, int k) {
        // code here
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1];
        solve(root, k, list, count);
        return count[0];
    }
}
