// You are given two linked lists that represent two large positive numbers. These two numbers are represented by the linked lists, 
// subtract the smaller number from the larger one. Look at the examples to get a better understanding of the task.


class Solution {
    int length(Node head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    Node reverse(Node curr){
        if(curr == null || curr.next == null) return curr;
        Node nxt = null, prev = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        while(head1 != null && head1.data == 0){
            head1 = head1.next;
        }
        while(head2 != null && head2.data == 0){
            head2 = head2.next;
        }
        if(head1 == null && head2 == null){
            return new Node(0);
        }
        int n1 = length(head1);
        int n2 = length(head2);
        
        if(n2 > n1){
            Node t = head1;
            head1 = head2;
            head2 = t;
        }
        
        if(n1 == n2){
            Node temp1 = head1, temp2 = head2;
            while(temp1.data == temp2.data){
                temp1 = temp1.next;
                temp2 = temp2.next;
                if(temp1 == null) return new Node(0);
            }
            if(temp2.data > temp1.data){
                Node t = head1;
                head1 = head2;
                head2 = t;
            }
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        Node res = null, last = null;
        Node temp1 = head1, temp2 = head2;
        
        while(temp1 != null){
            int small = 0;
            if(temp2 != null){
                small = temp2.data;
            }
            if(temp1.data < small){
                temp1.next.data = temp1.next.data - 1;
                temp1.data = temp1.data + 10;
            }
            Node n = new Node(temp1.data - small);
            if(res == null){
                res = n;
                last = n;
            }else{
                last.next = n;
                last = last.next;
            }
            temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        res = reverse(res);
        while(res != null && res.data == 0){
            res = res.next;
        }
        return res;
    }
}
