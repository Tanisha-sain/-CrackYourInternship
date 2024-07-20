// A peak element is an element that is strictly greater than its neighbors.


// O(n)
class Solution1 {
    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        else if(nums[n-1] > nums[n-2]) return n-1; 
        else{
            for(int i = 1; i<n-1; i++){
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
            }
        }
        return -1;
    }
}

// O(log n)
class Solution2 {
    public int findPeakElement2(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while(s<e){
            int m = s + (e-s)/2;
            if(nums[m]>nums[m+1]){
                e = m;
            }else{
                s = m+1;
            }
        }
        return s;
    }
}
