// Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of 
// searches to keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
// Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp = new int[n][n];
        for(int g = 0; g<n; g++){
            for(int i = 0, j = g; j<n; i++, j++){
                if(g == 0){
                    dp[i][j] = freq[i];
                }else if(g == 1){
                    int fr1 = freq[i];
                    int fr2 = freq[j];
                    dp[i][j] = Math.min(fr1 + 2*fr2 , fr2 + 2*fr1);
                }else{
                    int min = Integer.MAX_VALUE;
                    int fs = 0;
                    for(int k = i; k<=j; k++){
                        fs += freq[k];
                    }
                    for(int k = i; k<=j; k++){
                        int left = (k == i) ? 0 : dp[i][k-1];
                        int right = (k == j) ? 0 : dp[k+1][j];
                        
                        if(left + right + fs < min){
                            min = left + right + fs;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }
}
