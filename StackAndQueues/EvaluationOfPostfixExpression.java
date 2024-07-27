//  Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. 
// Operators will only include the basic arithmetic operators like *, /, + and -.


class Solution{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S){
        // Your code here
        Stack<Integer> stack = new Stack<>();

        for(char ch : S.toCharArray()){
            if(ch <= '9' && ch >= '0'){
                stack.push(ch-'0');
            }else{
                int n1 = 0, n2 = 0;
                n2 = stack.pop();
                n1 = stack.pop();
                switch(ch){
                    case '+': {
                        stack.push(n1 + n2);
                        break;
                    }
                    case '-': {
                        stack.push(n1 - n2);
                        break;
                    }
                    case '*': {
                        stack.push(n1*n2);
                        break;
                    }
                    case '/': {
                        stack.push(n1/n2);
                        break;
                    }  
                }
            }
        }
        return stack.pop();
    }
}
