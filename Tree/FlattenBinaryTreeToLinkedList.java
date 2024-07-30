// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to 
// the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.


class Solution {
    TreeNode helper(TreeNode root){
        if(root == null) return root;
        TreeNode right = root.right;
        root.right = helper(root.left);
        root.left = null;
        TreeNode temp = root;
        while(temp != null && temp.right != null){
            temp = temp.right;
        }
        temp.right = helper(right);
        return root;
    }
    public void flatten(TreeNode root) {
        root = helper(root);
    }
}
