// Given a Binary Search Tree that contains unique positive integer values greater than 0.
// The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false.
// Here Dead End means a leaf node, at which no other node can be inserted.

class Solution
{
    static boolean helper(Node root, int l, int h){
        if(root == null) return false;
        if(h-l-1 == 1) return true;
        return helper(root.left, l, root.data) || helper(root.right, root.data, h);
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return helper(root, 0, 10002);
    }
}
