// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

class Solution {
    TreeNode build(int[] nums, int i, int j){
        if(i > j) return null;
        int mid = (i + j)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, i, mid-1);
        node.right = build(nums, mid+1, j);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
}
