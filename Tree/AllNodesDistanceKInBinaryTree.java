// Given the root of a binary tree, the value of a target node target, and an integer k, 
// return an array of the values of all nodes that have a distance k from the target node.
// You can return the answer in any order


class Solution {
    void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && !visited.containsKey(curr.left)){
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && !visited.containsKey(curr.right)){
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    queue.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}
