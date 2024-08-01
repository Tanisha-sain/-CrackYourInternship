// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
// serialization/deserialization algorithm should work. You just need to ensure that a binary tree can 
// be serialized to a string and this string can be deserialized to the original tree structure.


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        for(int i = 1; i<values.length; i++){
            TreeNode parent = queue.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
