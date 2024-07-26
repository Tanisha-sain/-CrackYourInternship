// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
// In one move, you can increment or decrement an element of the array by 1.

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int s = 0, e = n-1;
        int mid = s + (e - s + 1)/2;
        int ans = 0;
        for(int num : nums){
            ans += Math.abs(num - nums[mid]);
        }
        return ans;
    }
}
