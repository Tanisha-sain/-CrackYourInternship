// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
// represented by an array nums. You are asked to burst all the balloons.
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1
// goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
// Return the maximum coins you can collect by bursting the balloons wisely.

class Solution {
    int helper(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;
        int max = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind = i; ind <=j; ind++){
            int coins = nums[ind];
            if(i > 0) coins *= nums[i-1];
            if(j < nums.length-1) coins *= nums[j+1];

            coins += helper(i, ind-1, nums, dp);
            coins += helper(ind+1, j, nums, dp);

            if(coins > max) max = coins;
        }
        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(0,n-1, nums, dp);
    }
}
