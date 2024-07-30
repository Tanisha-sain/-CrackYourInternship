// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
// such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

class Solution {
    boolean helper(TreeNode root, int sum, int curr){
        if(root == null) return false;
        curr += root.val;
        if(root.left == null && root.right == null){
            if(sum == curr) return true;
            return false;
        }
        return helper(root.left, sum, curr) || helper(root.right, sum, curr);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
}
