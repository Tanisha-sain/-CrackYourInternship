// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                if(len > max) max = len;
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }
}
