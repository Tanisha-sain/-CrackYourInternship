// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
// (i.e., from left to right, then right to left for the next level and alternate between).

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<levelSize; i++){
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            if(!flag) Collections.reverse(temp);
            list.add(temp);
            flag = !flag;
        }

        return list;
    }
}
