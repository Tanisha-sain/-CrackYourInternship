// A string s is called good if there are no two different characters in s that have the same frequency.
// Given a string s, return the minimum number of characters you need to delete to make s good.
// The frequency of a character in a string is the number of times it appears in the string. 
// For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        int deletions = 0;
        for(int i = 0; i<26; i++){
            if(freq[i] > 0){
                if(!set.contains(freq[i])){
                    set.add(freq[i]);
                }else{
                    while(set.contains(freq[i])){
                        freq[i]--;
                        deletions++;
                        // System.out.println(i + " " + freq[i] + " " + deletions);
                        if(!set.contains(freq[i]) && freq[i] > 0){
                            set.add(freq[i]);
                            break;
                        }
                    }
                }
            }
        }
        return deletions;
    }
}
