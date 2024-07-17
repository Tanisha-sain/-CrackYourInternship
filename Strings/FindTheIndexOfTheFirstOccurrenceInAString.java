//  Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int j = 0;;
        for(int i = 0; i<n; i++){
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            else{
                i = i - j;
                j = 0;
            }
            if(j == m) return i - m + 1;
        }
        return -1;
    }
}
