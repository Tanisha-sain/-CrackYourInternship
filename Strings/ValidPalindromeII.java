// Given a string s, return true if the s can be palindrome after deleting at most one character from it.


class Solution {
    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return isPalindrome(s, i+1, j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }
}