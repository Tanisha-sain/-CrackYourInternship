// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

class Solution {
    ListNode middleNode(ListNode head){
        ListNode slow =  head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode mid){
        ListNode curr = mid, prev = null, nxt = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = middleNode(head);
        ListNode left = head;
        ListNode right = reverse(mid);
        while(right != null){
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
