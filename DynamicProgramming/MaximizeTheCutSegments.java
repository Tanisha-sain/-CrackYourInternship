// Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that 
// the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
// After performing all the cut operations, your total number of cut segments must be maximum.
// Note: if no segment can be cut then return 0.

class Solution{
    //Function to find the maximum number of cuts.
    int helper(int n, int x, int y, int z, int[] dp){
        if(n == 0) return 0;
        if(n < 0) return Integer.MIN_VALUE;
        
        if(dp[n] != -1) return dp[n];
        int xc = 1 + helper(n-x, x, y, z, dp);
        int yc = 1 + helper(n-y, x, y, z, dp);
        int zc = 1 + helper(n-z, x, y, z, dp);
        
        return dp[n] = Math.max(xc, Math.max(yc, zc));
    }
    public int maximizeCuts(int n, int x, int y, int z){
       //Your code here
       int[] dp = new int[n+1];
       Arrays.fill(dp, -1);
       int ans = helper(n, x, y, z, dp);
       if(ans < 0) return 0;
       return ans;
    }
}
