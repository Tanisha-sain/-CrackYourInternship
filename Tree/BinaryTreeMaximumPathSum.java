// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
// A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.

class Solution {
    int maxPath(TreeNode root, int[] max){
        if(root == null) return 0;
        int leftMax = Math.max(0, maxPath(root.left, max));
        int rightMax = Math.max(0, maxPath(root.right, max));
        max[0] = Math.max(max[0], leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }
}
