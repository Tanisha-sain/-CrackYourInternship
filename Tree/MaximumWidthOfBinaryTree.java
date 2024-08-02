// Given the root of a binary tree, return the maximum width of the given tree.
// The maximum width of a tree is the maximum width among all levels.
// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
// where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that
// level are also counted into the length calculation.
// It is guaranteed that the answer will in the range of a 32-bit signed integer.

class Solution {
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode n, int i){
            node = n;
            index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int levelSize = q.size();
            int min = q.peek().index;
            int first = 0;
            int last = 0;

            for(int i = 0; i<levelSize; i++){
                int curr = q.peek().index - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0) first = curr;
                if(i == levelSize -1 ) last = curr;
                if(node.left != null) q.offer(new Pair(node.left, curr*2+1));
                if(node.right != null) q.offer(new Pair(node.right, curr*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}
