// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.


class Solution {
    ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        ListNode t1 = h1, t2 = h2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1;
                t1 = t1.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 == null) temp.next = t2;
        if(t2 == null) temp.next = t1;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];
        if(n == 2) return merge(lists[0],lists[1]);

        ListNode[] firstHalf = new ListNode[n/2];
        ListNode[] secondHalf = new ListNode[n-n/2];
        int mid = n/2;
        for(int i = 0 ; i <mid ; i++){
            firstHalf[i] = lists[i];
        }
        for(int i = mid ; i < n ; i++){
            secondHalf[i-mid] = lists[i];
        }

        ListNode a = mergeKLists(firstHalf);
        ListNode b = mergeKLists(secondHalf);
        return merge(a,b);
    }
}
