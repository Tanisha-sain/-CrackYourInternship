// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=s.length(); i++){
            if(i == s.length() || s.charAt(i) == ' '){
                if(sb.length() != 0) list.add(sb.toString());
                sb.setLength(0);
            }
            else sb.append(s.charAt(i));
        }
        sb.setLength(0);
        for(int i = list.size()-1; i>= 0; i--){
            sb.append(list.get(i));
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
