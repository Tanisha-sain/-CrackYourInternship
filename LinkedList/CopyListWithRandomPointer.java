// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
// Construct a deep copy of the list. 


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node curr = map.get(temp);
            curr.next = map.get(temp.next);
            curr.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
