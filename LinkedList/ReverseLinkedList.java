// Given the head of a singly linked list, reverse the list, and return the reversed list.


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head, prev = null;
        ListNode nxt = curr.next;

        while(curr.next != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;  
            curr = nxt;
        }
        curr.next = prev;
        return curr;
    }
}
