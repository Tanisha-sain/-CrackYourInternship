// There is an integer array nums that consists of n unique elements, but you have forgotten it.
// However, you do remember every pair of adjacentelements in nums.
// You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi]
// indicates that the elements ui and vi are adjacent in nums.
// It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, 
// either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
// Return the original array nums. If there are multiple solutions, return any of them.


class Solution {   
    public int[] restoreArray(int[][] adjacentPairs) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] pair : adjacentPairs){
            int u = pair[0];
            int v = pair[1];
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            if(!graph.containsKey(v)){
                graph.put(v, new ArrayList<>());
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size() == 1){
                ans.add(entry.getKey());
                ans.add(entry.getValue().get(0));
                break;
            }
        }
        while(ans.size() < graph.size()){
            int lastElement = ans.get(ans.size()-1);
            int secLastElement = ans.get(ans.size()-2);
            ArrayList<Integer> temp = graph.get(lastElement);
            if(temp.get(0) != secLastElement){
                ans.add(temp.get(0));
            }else{
                ans.add(temp.get(1));
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
