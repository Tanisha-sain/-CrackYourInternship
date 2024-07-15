// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant extra space.

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] map = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            if(map[num-1] == 1) ans.add(num);
            map[num - 1]++;
        }
        return ans;
    }
}
