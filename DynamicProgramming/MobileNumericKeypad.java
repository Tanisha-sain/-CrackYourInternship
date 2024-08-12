// There is a standard numeric keypad on a mobile phone. You can only press the current button or buttons that are 
// directly up, left, right, or down from it (for ex if you press 5, then pressing 2, 4, 6 & 8 are allowed). 
// Diagonal movements and pressing the bottom row corner buttons (* and #) are prohibited.
// Given a number n, find the number of possible unique sequences of length n that you can create by 
// pressing buttons. You can start from any digit.

class Solution {
    int[][] moves = {
        {0,8},
        {1,2,4},
        {2,1,3,5},
        {3,2,6},
        {4,1,5,7},
        {5,2,4,6,8},
        {6,3,5,9},
        {7,4,8},
        {8,5,7,9,0},
        {9,6,8}
    };
    long solve(int digit, int n, long[][] dp){
        if(n == 0) return 1;
        if(dp[n][digit] != -1) return dp[n][digit];
        long ans = 0;
        for(int nextDigit : moves[digit]){
            ans += solve(nextDigit, n-1, dp);
        }
        return dp[n][digit] = ans;
    }
    public long getCount(int n) {
        // Your code goes here
        long[][] dp = new long[n][10];
        for(long[] temp : dp){
            Arrays.fill(temp, -1);
        }
        long ans = 0;
        for(int i = 0; i<10; i++){
            ans += solve(i, n-1, dp);
        }
        return ans;
    }
}
