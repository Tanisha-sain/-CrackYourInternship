// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pref = new int[n];
        pref[0] = height[0];
        for(int i = 1; i<n; i++){
            pref[i] = Math.max(height[i], pref[i-1]);
        }
        int[] suff = new int[n];
        suff[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            suff[i] = Math.max(height[i], suff[i+1]);
        }
        int water = 0;
        for(int i = 0; i<n; i++){
            int h = Math.min(pref[i], suff[i]) - height[i];
            water += h;
        }
        return water;
    }
}
