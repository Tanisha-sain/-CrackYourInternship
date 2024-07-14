// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];

        for(int num : nums){
            if(count[num] == 1) return num;
            count[num]++;
        }

        return -1;
    }
}
