// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i = 0; i<n;i++){
            for(int j = i; j<n;j++){
                int currSum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
                if(currSum == k) count++;
            }
        }
        return count;
    }
}


// Optimized code using HashMap


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0,1);
        int preSum = 0, count = 0;
        for(int i = 0; i<n; i++){
            preSum += nums[i];
            int rem = preSum - k;
            if(map.containsKey(rem)) count += map.get(rem);
            map.put(preSum, map.getOrDefault(preSum,0) + 1);
        }

        return count;
    }
}

