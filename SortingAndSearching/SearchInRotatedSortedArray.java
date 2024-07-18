// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n-1;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[s]){
                if(target < nums[mid] && target >= nums[s]){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[e]){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
        }
        return -1;
    }
}
