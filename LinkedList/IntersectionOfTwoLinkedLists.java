// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
// If the two linked lists have no intersection at all, return null.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode a = headA, b = headB;
        while(a != null){
            map.put(a, 1);
            a = a.next;
        }
        while(b != null){
            if(map.containsKey(b)) return b;
            b = b.next;
        }
        return null;
    }
}
