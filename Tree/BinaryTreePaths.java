// Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

class Solution {
    void helper(TreeNode root, List<String> list, StringBuilder curr){
        if (root == null) {
            return;
        } 
        int len = curr.length();
        curr.append(root.val);
        
        if (root.left == null && root.right == null) {
            list.add(curr.toString());
        } else {
            curr.append("->");
            helper(root.left, list, curr);
            helper(root.right, list, curr);
        }     
        curr.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(root, list, curr);
        return list;
    }
}
