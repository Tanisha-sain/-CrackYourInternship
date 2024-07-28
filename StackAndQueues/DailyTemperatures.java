// Given an array of integers temperatures represents the daily temperatures, return an array answer 
// such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
// If there is no future day for which this is possible, keep answer[i] == 0 instead.


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n-1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i = n-2; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = 0;
            else ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
