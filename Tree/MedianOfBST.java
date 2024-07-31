// Given a Binary Search Tree of size N, find the Median of its Node values.

class Tree
{
    static void inorder(Node root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public static float findMedian(Node root)
    {
        // code here.
        if(root.left == null && root.right == null) return (float)(root.data);
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        float ans = 0;
        if(n%2 == 0){
            ans = (float)(list.get(n/2) + list.get(n/2 - 1))/2;
        }else{
            ans = (float)(list.get(n/2));
        }
        return ans;
    }
}
