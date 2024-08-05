// Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
// Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. 
// Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] 
// is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
// Return the minimum time Bob needs to make the rope colorful.

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if(n == 1) return 0;
        int ans = 0;
        int prev = 0, curr = 1;
        while(curr < n){
            if(colors.charAt(prev) == colors.charAt(curr)){
                if(neededTime[prev] < neededTime[curr]){
                    ans += neededTime[prev];
                    prev = curr;
                }else{
                    ans += neededTime[curr];
                }
                curr++;
            }else{
                prev = curr;
                curr++;
            }
        }
        return ans;
    }
}
