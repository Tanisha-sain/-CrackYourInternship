// Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. 
// (Not just immediate Right , but entire List on the Right)


class Solution{
    Node reverse(Node head){
        Node nxt = null, prev = null;
        while(head != null){
            nxt = head.next;
            head.next = prev;
            prev = head; 
            head = nxt;
        }
        return prev;
    }
    Node compute(Node head){
        // your code here
        if(head == null || head.next == null) return head;
        Node rev = reverse(head);
        int max = Integer.MIN_VALUE;
        Node prev = null, curr = rev, ans = null;
        while(curr != null){
            if(curr.data >= max){
                if(ans == null) ans = curr;
                prev = curr;
                max = curr.data;
            }else if(curr.data < max){
                prev.next = curr.next;
            }
            curr = curr.next;
            //System.out.println(max);
        }
        return reverse(ans);
        
    }
}
  
