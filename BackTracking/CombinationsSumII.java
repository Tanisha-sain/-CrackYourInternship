// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.


class Solution {
    void helper(int i, int[] arr, int target, List<List<Integer>> ans,  List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j<arr.length; j++){
            if(j > i && arr[j] == arr[j-1]) continue;
            if(arr[j] > target) break;

            list.add(arr[j]);
            helper(j+1, arr, target-arr[j], ans, list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
