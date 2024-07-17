// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        if(n < 4 || (long)((long)(nums[0] + nums[1]) + (long)(nums[2] + nums[3])) > target || (long)((long)(nums[n-1] + nums[n-2]) + (long)(nums[n-3] + nums[n-4])) < target) return ans;

        for(int i = 0; i<n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k < l){
                    long sum4 = nums[i] + nums[j];
                    sum4 += nums[k];
                    sum4 += nums[l];
                    if(sum4 == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }else if(sum4 < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}
