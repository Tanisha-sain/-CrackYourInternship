// Given the root of a binary tree, invert the tree, and return its root.

class Solution {
    void invert(TreeNode root){
        if(root == null) return;
        invert(root.left);
        invert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
