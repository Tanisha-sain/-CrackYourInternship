// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode temp1 = less, temp2 = more, temp = head;

        while(temp != null){
            int data = temp.val;
            if(data < x){
                less.next = temp;
                less = less.next;
            }else{
                more.next = temp;
                more = more.next;
            }
            temp = temp.next;
        }
        less.next = temp2.next;
        more.next = null;
        return temp1.next;
    }
}
