// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
// A subarray is a contiguous part of an array.

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i = 0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i]%k + k;
        }
        for(int i = 0; i<=n; i++){
            prefix[i] = prefix[i]%k;
        }

        for(int pre : prefix){
            if(map.containsKey(pre)){
                ans += map.get(pre);
                map.put(pre, map.get(pre)+1);
            }else{
                map.put(pre,1);
            }
        }
        return ans;
    }
}
