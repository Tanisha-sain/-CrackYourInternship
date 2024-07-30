// There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key.
// If either predecessor or successor is not found, then set it to NULL.
// Note:- In an inorder traversal the number just smaller than the target is the predecessor and 
// the number just greater than the target is the successor. 


class Solution {    
    static void helper(Node root, Node[] pre, Node[] suc, int key){
        if(root == null) return;
        if(root.data < key && pre[0].data < root.data) pre[0] = root;
        if(root.data > key && suc[0].data > root.data) suc[0] = root;
        helper(root.left, pre, suc, key);
        helper(root.right, pre, suc, key);
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        pre[0] = new Node(Integer.MIN_VALUE);
        suc[0] = new Node(Integer.MAX_VALUE);
        
        helper(root, pre, suc, key);
        
        if(pre[0].data == Integer.MIN_VALUE) pre[0] = new Node(-1);
        if(suc[0].data == Integer.MAX_VALUE) suc[0] = new Node(-1);
    }
}
