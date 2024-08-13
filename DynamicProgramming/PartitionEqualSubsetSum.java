// Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

class Solution{
    static int equalPartition(int N, int arr[]){
        // code here
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        if(totalSum%2 != 0) return 0;
        int sum = totalSum/2;
        
        int[][] dp = new int[N][sum+1];
        
        for(int i = 0; i<N; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= sum) dp[0][arr[0]] = 1;
        
        for(int i = 1; i<N; i++){
            for(int s = 1; s<=sum; s++){
                int notTake = dp[i-1][s];
                int take = 0;
                if(arr[i] <= s) take = dp[i-1][s-arr[i]];
                
                if(take == 1 || notTake == 1) dp[i][s] = 1;
            }
        }
        return dp[N-1][sum];
    }
}
