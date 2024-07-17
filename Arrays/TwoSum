// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1,-1};
        for(int i = 0; i<n; i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
