// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s 
// such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.



class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;

        while(r < n){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0){
                map.put(s.charAt(r), map.get(s.charAt(r))-1);
                count++;
                while(count == m){
                    if(r-l+1 < minLen){
                        minLen = r-l+1;
                        sIndex = l;
                    }
                    map.put(s.charAt(l), map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l)) > 0) count--;
                    l++;
                }
            }else{
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)-1);
            }
            r = r+1;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex+minLen);

    }
}
