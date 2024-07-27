// Given an array of strings, return all groups of strings that are anagrams. 
// The groups must be created in order of their appearance in the original array. 

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : string_list){
            StringBuilder h = new StringBuilder();
            int[] freq = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch-'a']++;
            }
            for(int i = 0; i<26; i++){
                h.append(freq[i]);
                h.append('#');
            }
            String hash = h.toString();
            if(map.containsKey(hash)){
                map.get(hash).add(str);
            }else{
                map.put(hash, new ArrayList<String>());
                map.get(hash).add(str);
            }
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> temp = entry.getValue();
            ans.add(temp);
        }
        return ans;
    }
}
