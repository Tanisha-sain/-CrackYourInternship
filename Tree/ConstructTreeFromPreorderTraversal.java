// Construct a binary tree of size N using two given arrays pre[] and preLN[]. Array pre[] represents preorder traversal of a binary tree. 
// Array preLN[] has only two possible values L and N. The value L in preLN[] indicates that the corresponding node in Binary Tree is a 
// leaf node and value N indicates that the corresponding node is a non-leaf node.
// Note: Every node in the binary tree has either 0 or 2 children.


class Solution{
    static int index = -1;
    Node build(int n, int[] pre, char preLN[]){
        index++;
        if(index == n) return null;
        Node node = new Node(pre[index]);
        if(preLN[index] == 'L'){
            node.left = null;
            node.right = null;
        }else{
            node.left = build(n, pre, preLN);
            node.right = build(n, pre, preLN);
        }
        return node;
    }
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    index = -1;
	    return build(n,pre,preLN);
    }
}
