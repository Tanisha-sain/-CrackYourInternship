// Given the root node of a binary search tree and two integers low and high, 
// return the sum of values of all nodes with a value in the inclusive range [low, high].

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int ans = 0;
        if(root.val <= high && root.val >= low){
            ans += root.val;
            ans += rangeSumBST(root.left,low,high);
            ans += rangeSumBST(root.right, low, high);
        }else if(root.val < low){
            ans += rangeSumBST(root.right, low, high);
        }else if(root.val > high){
            ans += rangeSumBST(root.left, low, high);
        }
        return ans;

    }
}
