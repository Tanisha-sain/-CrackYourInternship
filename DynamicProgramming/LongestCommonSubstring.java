// You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
