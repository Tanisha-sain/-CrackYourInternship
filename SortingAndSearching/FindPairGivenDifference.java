// Given an array arr[] of size n and an integer x, return 1 if there exists a pair of elements in the array whose absolute difference is x, 
// otherwise, return -1.

class Solution {
    public int findPair(int n, int x, int[] nums) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(map.containsKey(nums[i]-x) || map.containsKey(nums[i]+x)) return 1;
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        return -1;
    }
    
}
