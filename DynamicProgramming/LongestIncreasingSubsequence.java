// Given an integer array nums, return the length of the longest strictly increasing subsequence.

class Solution {
    int helper(int curr, int[] nums, int prev, int[][] dp){
        if(curr < 0) return 0;

        if(dp[curr][prev] != -1) return dp[curr][prev];
        int notTake = helper(curr-1, nums, prev, dp);
        int take = 0;
        if(prev == nums.length || nums[curr] < nums[prev]){
            take = 1 + helper(curr-1, nums, curr, dp);
        }

        return dp[curr][prev] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(n-1, nums, n, dp);
    }
}
