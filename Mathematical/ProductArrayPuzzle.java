// Given an array nums[] of size n, construct a Product Array P (of same size n) 
// such that P[i] is equal to the product of all the elements of nums except nums[i].

class Solution { 
	public static long[] productExceptSelf(int nums[], int n) { 
        // code here
        long[] left = new long[n];
        long[] right = new long[n];
        
        left[0] = 1;
        right[n-1] = 1;
        
        for(int i = 0; i<n-1; i++){
            left[i+1] = left[i]*nums[i];
        }
        for(int i = n-1; i>0; i--){
            right[i-1] = right[i]*nums[i];
        }
        for(int i = 0; i<n;i++){
            left[i] *= right[i];
        }
        return left;
	} 
} 
