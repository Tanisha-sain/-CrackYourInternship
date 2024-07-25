// Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    void swap(int[][] nums, int a, int b){
        int[] temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        int[][] v = new int[n][2];
        for(int i = 0; i<n; i++){
            v[i][0] = nums[i];
            v[i][1] = i;
        }
        Arrays.sort(v, (a,b)-> a[0]-b[0]);
        int c = 0;
        for(int i = 0; i<n; i++){
            if(v[i][1] != i){
                c++;
                swap(v,i,v[i][1]);
                i--;
            }
        }
        return c;
    }
}
