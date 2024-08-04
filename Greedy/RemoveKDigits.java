// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && k > 0 && (stack.peek() - '0') > (num.charAt(i) - '0')){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        while(sb.length() != 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() == 0) return "0";
        sb = sb.reverse();
        return sb.toString();
    }
}
