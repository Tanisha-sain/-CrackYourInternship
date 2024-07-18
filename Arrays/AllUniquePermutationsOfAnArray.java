// Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. 
// A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

class Solution {
    static void permutation(ArrayList<Integer> arr , int n, int curr, boolean[] vis, ArrayList<Integer> p, ArrayList<ArrayList<Integer>> list){
        if(curr == n){
            list.add(new ArrayList<>(p));
            return;
        }

        for(int j = 0; j<n; j++){
            if(!vis[j]){
                if(j > 0){
                    if(arr.get(j) != arr.get(j-1) || vis[j-1]){
                    p.add(arr.get(j));
                    vis[j] = true;
                    permutation(arr,n,curr+1,vis,p,list);
                    vis[j] = false;
                    p.remove(p.size()-1);
                    }
                }else{
                    p.add(arr.get(j));
                    vis[j] = true;
                    permutation(arr,n,curr+1,vis,p,list);
                    vis[j] = false;
                    p.remove(p.size()-1);
                }
            }
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        
        Collections.sort(arr);
        
        permutation(arr, n, 0, vis, p, list);
        return list;
    }
};
