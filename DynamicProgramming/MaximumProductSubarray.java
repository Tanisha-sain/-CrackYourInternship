// Given an integer array nums, find a subarray that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        double pref = 1, suff = 1;
        double ans = nums[0];
        for(int i = 0; i<n; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;
            pref *= nums[i];
            suff *= nums[n-i-1];

            ans = Math.max(ans, Math.max(pref, suff));

        }
        return (int)ans;
    }
}
