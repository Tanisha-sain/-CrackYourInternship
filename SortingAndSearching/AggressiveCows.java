// You are given an array consisting of n integers which denote the position of a stall. 
// You are also given an integer k which denotes the number of aggressive cows. 
// You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
// The first line of input contains two space-separated integers n and k.
// The second line contains n space-separated integers denoting the position of the stalls.


class Solution {
    static boolean canWePlace(int[] nums, int dist, int cows, int n){
        int count = 1, last = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] - last >= dist){
                count++;
                last = nums[i];
            }
            if(count == cows) return true;
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s = 1;
        int e = stalls[n-1] - stalls[0];
        while(s <= e){
            int mid = s + (e-s)/2;
            if(canWePlace(stalls, mid, k, n)){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return e;
    }
}
