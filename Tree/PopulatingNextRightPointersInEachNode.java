// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

class Solution {
    void helper(Node root1, Node root2){
        if(root1 == null || root2 == null) return;
        root1.next = root2; 
        helper(root1.left, root1.right);
        helper(root2.left, root2.right);
        helper(root1.right, root2.left);

    }
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root.left, root.right);
        return root;
    }
}
