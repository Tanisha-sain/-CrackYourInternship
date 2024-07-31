// Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
// - The values smaller than root go to the left side.
// - The values greater and equal to the root go to the right side.

class Solution{
    //Function to count number of nodes in BST that lie in the given range.
    int helper(Node root, int l, int h){
        if(root == null) return 0;
        
        if(root.data >= l && root.data <= h){
            return 1 + helper(root.left,l,h) + helper(root.right,l,h);
        }else if(root.data < l){
            return helper(root.right, l, h);
        }
        return helper(root.left, l, h);
    }
    int getCount(Node root,int l, int h){
        //Your code here
        
        return helper(root, l, h);
    }
}
