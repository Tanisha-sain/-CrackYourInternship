// Given a binary tree. Find the size of its largest subtree which is a Binary Search Tree.
// Note: Here Size equals the number of nodes in the subtree.

class Solution{
    static class Temp{
        int size;
        int max;
        int min;
        
        Temp(int s, int mx, int mn){
            this.size = s;
            this.max = mx;
            this.min = mn;
        }
    }
    
    static Temp helper(Node root){
        if(root == null){
            return new Temp(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Temp left = helper(root.left);
        Temp right = helper(root.right);
        
        if(root.data > left.max && root.data < right.min){
            int s = 1 + left.size + right.size;
            int max = Math.max(root.data, Math.max(left.max, right.max));
            int min = Math.min(root.data, Math.min(left.min, right.min));
            return new Temp(s, max, min);
        }
        
        int s = Math.max(left.size, right.size);
        return new Temp(s, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root){
        // Write your code here
        return helper(root).size;    
    }   
}
