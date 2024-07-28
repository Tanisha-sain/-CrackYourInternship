// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
// If there is no next greater element, then the answer for this query is -1.
// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n-1], -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[n-1]);
        for(int i = n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            //System.out.println(stack.isEmpty());
            if(stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i],stack.peek());
            stack.push(nums2[i]);
        }
        int[] ans = new int[m];
        for(int i = 0; i<m; i++){
            //System.out.println(map.get(nums1[i]));
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}