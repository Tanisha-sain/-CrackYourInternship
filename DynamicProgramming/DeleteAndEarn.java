// You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1and every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;

        int[] freq = new int[n];
        for(int num : nums){
            freq[num] += num;
        }
        int take = 0, skip = 0;
        for(int i = 0; i<n; i++){
            int t = skip + freq[i];
            int s = Math.max(skip, take);
            take = t;
            skip = s;
        }
        return Math.max(take, skip);
    }
}
