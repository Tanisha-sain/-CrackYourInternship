// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int c = 0;
        while(l1 != null || l2 != null || c != 0){
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            int sum = n1 + n2 + c;
            c = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        dummy = dummy.next;
        return dummy;
    }
}
