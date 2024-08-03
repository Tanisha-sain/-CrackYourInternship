// ou are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

class Solution {
    public int characterReplacement(String s, int k) {
        int n  = s.length();
        int i = 0, j = 0;
        int maxFreq = 0, maxLen = 0;
        int[] hash = new int[26];
        while(j < n){
            hash[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
            if((j - i + 1) - maxFreq > k){
                hash[s.charAt(i) - 'A']--;
                i++;
            }
            if((j-i+1)-maxFreq <= k){
                maxLen = Math.max(maxLen, (j-i+1));
            }
            j++;
        }
        return maxLen;
    }
}
