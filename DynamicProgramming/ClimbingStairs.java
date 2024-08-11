// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution {
    int climbStairs(int n, HashMap<Integer, Integer> map){
        if(n == 0 || n == 1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int temp = climbStairs(n-1, map) + climbStairs(n-2,map);
        map.put(n, temp);
        return map.get(n);
    }
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }
}
