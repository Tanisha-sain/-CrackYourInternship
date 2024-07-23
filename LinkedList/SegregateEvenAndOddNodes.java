// Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
// The order of appearance of numbers within each segregation should be same as that in the original list.

class Solution{
    Node divide(int N, Node head){
        // code here
        if(head == null || head.next == null) return head;
        Node odd = new Node(-1);
        Node even = new Node(-1);
        Node temp1 = odd, temp2 = even;
        
        while(head != null){
            if(head.data % 2 == 0){
                temp2.next = head;
                temp2 = temp2.next;
               // System.out.println(temp2.data);
            }else{
                temp1.next = head;
                temp1 = temp1.next;
            }
            head = head.next;
        }
        temp2.next = odd.next;
        temp1.next = null;
        return even.next;
    }
}
