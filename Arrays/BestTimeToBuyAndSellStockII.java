// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
// Find and return the maximum profit you can achieve. 


class Solution {
    int solve(int ind, int buy, int[] prices, int[][] dp){
        if(ind == prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 1){
            profit += Math.max((solve(ind+1,0,prices,dp) - prices[ind]), solve(ind+1,1,prices,dp));
        }else{
            profit += Math.max((solve(ind+1,1,prices,dp) + prices[ind]), solve(ind+1,0,prices,dp));
        }
        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
        return solve(0,1,prices,dp);
    }
}
