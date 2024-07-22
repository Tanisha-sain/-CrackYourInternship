// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.


class Solution {
    ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
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
    public ListNode reorderList(ListNode head) {
        if((head == null) || (head.next == null) || (head.next.next == null)) return head;
        ListNode mid = middleNode(head);
        ListNode left = head, right = reverse(mid);
        ListNode curr1 =  null, curr2 = null;
        while(right != null){
            curr1 = left.next;
            left.next = right;
            left = curr1;
            if(left == right) break;
            curr2 = right.next;
            right.next = left;
            right = curr2;
            if(left == right) break;
        }
        return head;
    }
}
