// Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
// The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list,
// and 1s in the mid of 0s and 2s.


class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        if(head == null || head.next == null) return head;
        Node curr0 = new Node(-1);
        Node curr1 = new Node(-1);
        Node curr2 = new Node(-1);
        Node zero = curr0, one = curr1, two = curr2;
        
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (curr1.next != null) ? curr1.next : curr2.next;
        one.next = curr2.next;
        two.next = null;
        return curr0.next;
    }
}
