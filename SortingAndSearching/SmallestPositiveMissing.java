// You are given an array arr[] of N integers. The task is to find the smallest positive number missing from the array.


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        Arrays.sort(arr);
        int i = 1;
        for(int num : arr){
            if(num < 1) continue;
            if(num == i) i++;
            else if(num > i) return i;
        }
        return i;
    }
}
