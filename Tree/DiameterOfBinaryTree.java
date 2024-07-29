// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

class Solution {
    static class Info{
        int dia;
        int ht;
        Info(int d, int h){
            dia = d;
            ht = h;
        }
    }
    Info helper(TreeNode root){
        if(root == null) return new Info(0,-1);
        Info left = helper(root.left);
        Info right = helper(root.right);

        int height = Math.max(left.ht, right.ht) + 1;
        int dia = Math.max(left.ht + right.ht + 2, Math.max(left.dia, right.dia));
        return new Info(dia, height);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia;
    }
}
