// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.


class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;      
        Arrays.sort(arr);
        for(int i = 0; i<n-2; i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = i+1, k = n-1;
            while(j < k){
                int sum3 = arr[i] + arr[j] + arr[k];
                if(sum3 == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k--;
                }else if(sum3 < 0) j++;
                else k--;
            }
        }
        return ans;
    }
}
