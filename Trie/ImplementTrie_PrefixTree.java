//  A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
// There are various applications of this data structure, such as autocomplete and spellchecker.
// Implement the Trie class:
// - Trie() Initializes the trie object.
// - void insert(String word) Inserts the string word into the trie.
// - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isLast;
        TrieNode(){
            children = new TrieNode[26];
            isLast = false;
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
}
