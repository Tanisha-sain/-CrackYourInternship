// You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. 
// This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. 
// These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
// Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. 
// Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
// Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.



class Solution {

    public Node flatten(Node head) {
        Node curr = head, tail = head;
        Stack<Node> stack = new Stack<>();
        while(curr != null){
            if(curr.child != null){
                Node child = curr.child;
                if(curr.next != null){
                    stack.push(curr.next);
                    curr.next.prev = null;
                }
                curr.next = child;
                child.prev = curr;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }
        while(!stack.isEmpty()){
            curr = stack.pop();
            tail.next = curr;
            curr.prev = tail;
            while(curr != null){
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
