// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.


class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == '#'){
                stack.pop();
            }else if(ch != '#'){
                stack.push(ch);
            }
        }
        s = "";
        while(!stack.isEmpty()){
            s += stack.pop();
        }

        for(char ch : t.toCharArray()){
            if(!stack.isEmpty() && ch == '#'){
                stack.pop();
            }else if(ch != '#'){
                stack.push(ch);
            }
        }
        int i = 0;
        while(!stack.isEmpty() && i < s.length()){
            if(s.charAt(i) != stack.peek()){
                return false;
            }
            i++;
            stack.pop();
        }
        if(!stack.isEmpty() || i<s.length()) return false;
        return true;
    }
}
