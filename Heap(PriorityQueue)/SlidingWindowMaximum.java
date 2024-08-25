// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            if(dq.size() > 0 && dq.peekFirst() <= i-k) dq.pollFirst();
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

            dq.addLast(i);
            if(i >= k-1) ans[j++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
