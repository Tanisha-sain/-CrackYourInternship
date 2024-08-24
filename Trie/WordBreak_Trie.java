// Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. 

class Solution
{
    static class TrieNode{
        TrieNode[] children;
        boolean isLast;
        TrieNode(){
            children = new TrieNode[26];
            isLast = false;
        }
    }
    static TrieNode root;
    static void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
                node = node.children[ch-'a'];
            }else{
                node = node.children[ch-'a'];
            }
        }
        node.isLast = true;
    }
    static boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isLast;
    }
    
    static boolean helper(String key){
        if(key.length() == 0) return true;
        for(int i = 1; i<=key.length(); i++){
            String first = key.substring(0,i);
            String second = key.substring(i,key.length());
            
            if(search(first) && helper(second)){
                return true;
            }
        }
        return false;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        root = new TrieNode();
        for(String str : B){
            insert(str);
        }
        
        return helper(A) ? 1 : 0;
    }
}
