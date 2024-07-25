// You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books,
// with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book 
// allotted to a student should be the minimum, out of all possible permutations.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


class Solution {
    // Function to find minimum number of pages.
    static long helper(int[] arr, long pages){
        long stu = 1, pageStu = 0;
        for(int num : arr){
            if(pageStu + num <= pages){
                pageStu += num;
            }else{
                stu++;
                pageStu = num;
            }
        }
        return stu;
    }
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m > n) return -1;
        long s = Integer.MIN_VALUE;
        long e = 0;
        for(int num : arr){
            e += num;
            if(num > s) s = num;
        }
        while(s <= e){
            long mid = s + (e-s)/2;
            long countStudent = helper(arr, mid);
            //System.out.println(s + " " + mid + " " + e + " " + countStudent);
            if(countStudent > m){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return s;
    }
};
