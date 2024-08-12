// The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
// or two squares horizontally and one square vertically (with both forming the shape of an L). 
// We have a chess knight and a phone pad, the knight can only stand on a numeric cell.
// Given an integer n, return how many distinct phone numbers of length n we can dial.
// You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps
// to dial a number of length n. All jumps should be valid knight jumps.
// As the answer may be very large, return the answer modulo 109 + 7.

class Solution {
    int[][] jumps = {
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {3,9,0},
        {},
        {1,7,0},
        {2,6},
        {1,3},
        {2,4}
    };
    int mod = 1000000007;
    int solve(int rem, int digit, int[][] dp){
        if(rem == 0) return 1;
        if(dp[rem][digit] != -1) return dp[rem][digit];

        int ans = 0;
        for(int nextDigit : jumps[digit]){
            ans = (ans + solve(rem-1, nextDigit, dp))%mod;
        }

        return dp[rem][digit] = ans%mod;
    }
    public int knightDialer(int n) {
        int[][] dp = new int[n+1][10];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        int ans = 0;
        for(int dig = 0; dig < 10; dig++){
            ans = (ans + solve(n-1, dig, dp))%mod;
        }

        return ans%mod;
    }
}
