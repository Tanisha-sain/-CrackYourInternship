// Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values 
// and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
// If there exist multiple answers, you can return any of them.

class Solution {
    TreeNode helper(int[] pre, int pres, int prel, int[] post, int posts, int postl){
        if(pres > prel) return null;
        TreeNode root = new TreeNode(pre[pres]);

        if(pres == prel) return root;
        int postIndex = posts;
        while(post[postIndex] != pre[pres + 1]) postIndex++;
        int len = postIndex - posts + 1;

        root.left = helper(pre, pres+1, pres+len, post, posts, postIndex);
        root.right = helper(pre, pres+len+1, prel, post, postIndex+1, postl-1);

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }
}
