// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 


class GfG{
    Node merge(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                temp.bottom = list1;
                list1 = list1.bottom;
            }else{
                temp.bottom = list2;
                list2 = list2.bottom;
            }
            temp = temp.bottom;
            // System.out.println(temp.data + " ");
        }
        if(list1 == null) temp.bottom = list2;
        else temp.bottom = list1;
        return dummy.bottom;
        
    }
    Node help(Node head){
        if(head == null || head.next == null) return head;
        Node node = help(head.next);
        return merge(head, node);
    }
    Node flatten(Node root){
	// Your code here
	    if(root == null || (root.next == null && root.bottom == null)) return root;
	    return help(root);
    }
}
