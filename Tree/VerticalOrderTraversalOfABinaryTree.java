// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively.
// The root of the tree is at (0, 0). The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index 
// starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column.
// In such a case, sort these nodes by their values.
// Return the vertical order traversal of the binary tree.


class Solution {
    class Temp{
        TreeNode node;
        int level;
        int vertical;
        Temp(TreeNode n, int r, int c){
            node = n;
            level = r;
            vertical = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Temp> q = new LinkedList<Temp>();
        q.offer(new Temp(root, 0, 0));
        while(!q.isEmpty()){
            Temp t = q.poll();
            TreeNode node = t.node;
            int x = t.level;
            int y = t.vertical;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Temp(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.offer(new Temp(node.right, x+1, y+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
