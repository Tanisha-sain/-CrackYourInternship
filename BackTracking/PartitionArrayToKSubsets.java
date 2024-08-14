// Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[]
// could be divided into K non-empty subsets with equal sum of elements.
// Note: All elements of this array should be part of exactly one partition.


class Solution
{
    boolean dfs(int[] a, int[] subsets, int ind, int target){
        if(ind == -1) return true;
        for(int i = 0; i<subsets.length; i++){
            if(subsets[i]+a[ind] > target) continue;
            subsets[i] += a[ind];
            if(dfs(a, subsets, ind-1, target)) return true;
            subsets[i] -= a[ind];
        }
        return false;
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here	
	    int sum = 0;
	    for(int num : a){
	        sum += num;
	    }
	    if(sum % k != 0) return false;
	    int x = sum/k;
	    
	    int[] subsets = new int[k];
	    Arrays.sort(a);
	    return dfs(a, subsets, n-1, x);
    }
}
