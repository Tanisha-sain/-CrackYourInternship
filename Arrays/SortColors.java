// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.


class Solution {   
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int k = n-1;
        while(j <= k){
            if(nums[j] == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }else if(nums[j] == 2){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }else{
                j++;
            }         
        }
    }
}
