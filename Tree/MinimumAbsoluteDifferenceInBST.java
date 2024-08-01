// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

class Solution {
    void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<list.size()-1; i++){
            int diff = list.get(i+1) - list.get(i);
            min = Math.min(min, diff);
        }
        return min;
    }
}
