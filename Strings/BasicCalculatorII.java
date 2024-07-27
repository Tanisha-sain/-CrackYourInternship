// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.

class Solution {
    public int calculate(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char sign = '+';
        for(int i = 0; i<n; i++){
            int num = 0;
            while(i<n && s.charAt(i) == ' ') i++;
            while(i<n && s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                num = num*10 + (s.charAt(i) - '0');
                i++;
            }
            while(i<n && s.charAt(i) == ' ') i++;
            switch(sign){
                case '+': {
                    stack.push(num);
                    break;
                }
                case '-': {
                    stack.push(-num);
                    break;
                }
                case '*':{
                    int prev = stack.pop();
                    stack.push(prev*num);
                    break;
                }
                case '/': {
                    int prev = stack.pop();
                    stack.push(prev/num);
                    break;
                }
            }
            if(i < n) sign = s.charAt(i);
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
