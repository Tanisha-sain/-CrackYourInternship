// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0];
        int count = 0;

        for(int num: nums){
            if(count == 0){
                ele = num;
                count = 1;
            }else if(num == ele) count++;
            else count--;
        }
        count = 0;
        for(int num: nums){
            if(num == ele) count++;
        }
        if(count > n/2) return ele;
        return -1;
    }
}
