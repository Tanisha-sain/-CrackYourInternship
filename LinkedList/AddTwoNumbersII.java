// You are given two non-empty linked lists representing two non-negative integers. 
// The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.


class Solution {
    ListNode reverse(ListNode list){
        if(list == null || list.next == null) return list;
        ListNode curr = list, prev = null, nxt = null;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1), r2 = reverse(l2);
        System.out.println(r1.val + " " + r2.val);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int c = 0;
        while(r1 != null || r2 != null || c != 0){
            int num1 = (r1 == null) ? 0 : r1.val;
            int num2 = (r2 == null) ? 0 : r2.val;

            int sum = num1 + num2 + c;
            
            System.out.println(num1 + " " + num2 + " " + c + " " + sum);
            c = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;

            r1 = (r1 == null) ? null : r1.next;
            r2 = (r2 == null) ? null : r2.next;
        }

        return reverse(dummy.next);
    }
}
