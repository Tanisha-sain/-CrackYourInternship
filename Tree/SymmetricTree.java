// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class Solution {
    boolean symmetric(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null || node1.val != node2.val) return false;
        return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }
}
