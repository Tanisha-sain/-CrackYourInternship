// Given an array arr[] of N nodes representing preorder traversal of some BST. You have to build the BST  from the given preorder traversal. 
// In Pre-Order traversal, the root node is visited before the left child and right child nodes.


static class Solution {
    
    public Node helper(int[] pre, int size, int ub, int[] index){
        if(index[0] == size || pre[index[0]] >= ub) return null;
        Node root = new Node(pre[index[0]]);
        index[0]++;
        root.left = helper(pre, size, root.data, index);
        root.right = helper(pre, size, ub, index);
        
        return root;
    }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        return helper(pre, size, Integer.MAX_VALUE, new int[]{0});
    }
}
