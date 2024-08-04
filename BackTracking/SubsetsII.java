// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    void findSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i = index; i<nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            findSubset(nums, i+1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSubset(nums, 0, res, new ArrayList<>());
        return res;
    }
}
