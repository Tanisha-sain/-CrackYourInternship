// Given a Linked list head, rearrange it such that the converted list should be of the form a < b > c < d > e < f .. 
// where a, b, c are consecutive data nodes of the linked list and such that the order of linked list is sustained.
// For example: In 11 15 20 5 10 we consider only 11 20 5 15 10 because it satisfies the above condition and the order of linked list. 
// 5 20 11 15 10 is not considered as it does not follow the order of linked list.
// To maintain the order, keep swapping the adjacent nodes of the linked list (whenever required) to get the desired output.  


class Solution {
    Node zigZag(Node head) {
        // add code here.
        if(head == null || head.next == null) return head;
        boolean flag = true;
        Node node = head;
        
        while(node.next != null){
            if((flag && (node.data > node.next.data)) || (!flag && (node.data < node.next.data))){
                int t = node.data;
                node.data = node.next.data;
                node.next.data = t;
            }
            flag = !flag;
            node = node.next;
        }
        return head;
    }
}
