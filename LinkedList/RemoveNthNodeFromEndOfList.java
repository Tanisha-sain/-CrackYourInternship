// Given the head of a linked list, remove the nth node from the end of the list and return its head.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int s = size - n;
        if(s == 0) return head.next;
        temp = head;
        for(int i = 0; i<s-1; i++){
            temp = temp.next;
        } 
        temp.next = temp.next.next;
        return head;
    }
}
