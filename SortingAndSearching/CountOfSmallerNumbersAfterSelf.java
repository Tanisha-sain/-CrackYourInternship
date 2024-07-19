// Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]

class Solution {
    int binarySearch(ArrayList<Integer> list, int ele){
        int n = list.size();
        int i = 0, j = n-1;
        int index = -1;
        while(i <= j){
            int mid = (i+j)/2;
            // System.out.println(i + " " + j + " " + mid + " " + list.get(mid) + " " + ele);
            if(list.get(mid) == ele){
                index = mid;
                j = mid-1;
            }else if(list.get(mid) > ele) j = mid-1;
            else i = mid+1;
        }
        return index;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        Collections.sort(list);

        for(int i = 0; i<nums.length; i++){
            int index = binarySearch(list,nums[i]);
            ans.add(index);
            if(index != -1) list.remove(index);
        }
        return ans;
    }
}
