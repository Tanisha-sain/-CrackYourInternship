// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n,k,new ArrayList<>(), ans);
        return ans;
    }
    void solve(int n, int k, List<Integer> curr, List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(n == 0) return;

        curr.add(n);
        solve(n-1,k-1,curr,ans);
        curr.remove(curr.size()-1);
        solve(n-1,k,curr,ans);
    }
}