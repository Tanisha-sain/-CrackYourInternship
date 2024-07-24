// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
// Return the linked list sorted as well.


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy, curr = head;

        while(curr != null){
            if((curr.next != null && curr.val != curr.next.val) || curr.next == null){
                temp.next = curr;
                temp = temp.next;
            }else{
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
            }
            curr = curr.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
