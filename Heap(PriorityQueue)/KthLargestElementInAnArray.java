//  Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<k; i++){
            pq.add(nums[i]);
        }
        for(int i = k; i<nums.length; i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.poll();
    }
}
