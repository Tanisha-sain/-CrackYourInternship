// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
// Since the answer may be large, return the answer modulo 109 + 7.


class Solution {
    public int[] findNse(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        nse[n-1] = n;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i = n-2; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) nse[i] = n;
            else nse[i] = stack.peek();
            stack.push(i);
        }
        return nse;
    }
    public int[] findPse(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        pse[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        long total = 0;
        for(int i = 0; i<arr.length; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (long)(total + ((left * right)%mod * arr[i])%mod)%mod;
        }
        return (int)total;
    }
}
