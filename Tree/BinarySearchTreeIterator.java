// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST)

class BSTIterator {
    
    List<Integer> list;
    int i;
    int n;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root, list);
        i = 0;
        n = list.size();
    }
    void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    public int next() {
        i++;
        return list.get(i-1);
    }
    
    public boolean hasNext() {
        if(i < n) return true;
        return false;
    }
}
