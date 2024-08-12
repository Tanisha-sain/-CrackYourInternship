// You are given an array of binary strings strs and two integers m and n.
// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
// A set x is a subset of a set y if all elements of x are also elements of y.

class Solution {
    int[] count(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }
    int helper(String[] strs, int m, int n, int curr, int[][][] dp){
        if(curr == strs.length || m+n == 0) return 0;

        if(dp[m][n][curr] != -1) return dp[m][n][curr];
        int[] count = count(strs[curr]);

        int take = 0;
        if(m >= count[0] && n >= count[1]){
            take = 1 + helper(strs, m-count[0], n-count[1], curr+1, dp);
        }

        int notTake = helper(strs, m, n, curr+1, dp);
        return dp[m][n][curr] = Math.max(take, notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];
        for(int[][] temp : dp){
            for(int[] arr : temp){
                Arrays.fill(arr, -1);
            }
        }
        return helper(strs, m, n, 0, dp);
    }
}
