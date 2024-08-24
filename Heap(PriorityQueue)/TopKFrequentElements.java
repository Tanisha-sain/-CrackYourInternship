// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

class Solution {
    class Pair{
        int element;
        int freq;
        Pair(int ele, int fre){
            element = ele;
            freq = fre;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = pq.poll().element;
        }
        return ans;
    }
}
