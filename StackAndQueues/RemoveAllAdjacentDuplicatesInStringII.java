// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, 
// causing the left and the right side of the deleted substring to concatenate together.
// We repeatedly make k duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        if(k == 1) return "";
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Pair(ch, 1));
            }else{
                Pair prev = stack.peek();
                if(ch == prev.ch){
                    prev.count++;
                    if(prev.count == k) stack.pop();
                }else{
                    stack.push(new Pair(ch, 1));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            Pair curr = stack.pop();
            for(int i = 0; i<curr.count; i++){
                ans.insert(0,curr.ch);
            }
        }
        return ans.toString();
    }
}
