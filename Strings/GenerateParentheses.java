// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

class Solution {
    void helper(String curr, int open, int close, int n, List<String> ans){
        if(open == n && close == n){
            ans.add(curr);
            return;
        }
        
        if(open < n){
            helper(curr+'(', open+1, close,n,ans);
        }

        if(open > close){
            helper(curr + ')', open, close+1, n, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("",0,0,n,ans);
        return ans;
    }
}
