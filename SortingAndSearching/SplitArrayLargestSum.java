// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.


class Solution {
    int helper(int[] nums, int sum){
        int count = 1, currSum = 0;
        for(int i = 0; i<nums.length; i++){
            if(currSum + nums[i] <= sum){
                currSum += nums[i];
            }else{
                count++;
                currSum = nums[i];
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for(int num : nums){
            high += num;
            if(num > low) low = num;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            int subCount = helper(nums, mid);
            if(subCount > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
