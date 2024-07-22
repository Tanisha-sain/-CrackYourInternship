// Given the head of a singly linked list and two integers left and right where left <= right, 
// reverse the nodes of the list from position left to position right, and return the reversed list.

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode curr = head, prev = null, nxt = null, last = null, first = null;

        for(int i = 0; i<left-1; i++){
            first = curr;
            curr = curr.next;
        }
        last = curr;
        int i = left-1;
        while(i != right && curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            i++;
        }
        if(first != null) first.next = prev;
        last.next = curr;
        if(left == 1){
            head = prev;
        }
        return head; 
    }
}
