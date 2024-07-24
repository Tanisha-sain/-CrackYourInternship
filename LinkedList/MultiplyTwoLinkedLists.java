// Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists, say L1 and L2.

class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long mod = 1000000007;
        long num1 = 0, num2 = 0;
        while(first != null){
            num1 = (num1*10)%mod + first.data;
            first = first.next;
        }
        while(second != null){
            num2 = (num2*10)%mod + second.data;
            second = second.next;
        }
        return (num1 * num2)%mod;
    }
}
