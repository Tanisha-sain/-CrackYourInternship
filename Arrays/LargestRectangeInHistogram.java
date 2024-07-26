// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
// return the area of the largest rectangle in the histogram.

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
}
