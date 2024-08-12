// You have intercepted a secret message encoded as a string of numbers.
// Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
// The test cases are generated so that the answer fits in a 32-bit integer.

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i = n-1; i >= 0; i--){
            int a = 0;
            int b = 0;

            if(s.charAt(i) > '0'){
                a = dp[i+1];
                if(i+1 < s.length()){
                    int num = Integer.valueOf(s.substring(i,i+2));
                    if(num > 0 && num < 27) b = dp[i+2];
                }
            }
            dp[i] = a+b;
        }
        return dp[0];

    }
}
