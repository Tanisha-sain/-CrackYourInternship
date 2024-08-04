// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    void findSubsets(int[] nums, int i, ArrayList<Integer> list){
        if(i == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        findSubsets(nums, i+1, list);
        list.remove(list.size()-1);

        findSubsets(nums, i+1, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return res;
    }
}
