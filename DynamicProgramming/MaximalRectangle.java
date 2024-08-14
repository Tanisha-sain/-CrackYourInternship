//  Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

class Solution {
     public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) rightSmall[i] = n-1;
            else rightSmall[i] = st.peek() - 1;
            st.push(i);
        }

        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, heights[i]*(rightSmall[i] - leftSmall[i] + 1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == '1'){
                    dp[j]++;
                }else{
                    dp[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(dp));
        }
        return max;
    }
}
