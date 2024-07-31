// Given the root of a binary tree, determine if it is a valid binary search tree (BST).


class Solution {
    boolean helper(TreeNode root, long low, long high){
        if(root == null ) return true;
        if(root.val >= high || root.val <= low) return false;

        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root) {
        // System.out.println(Integer.MAX_VALUE);
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
