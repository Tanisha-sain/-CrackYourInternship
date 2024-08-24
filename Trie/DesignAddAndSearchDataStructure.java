// Design a data structure that supports adding new words and finding if a string matches any previously added string.
// Implement the WordDictionary class:
// - WordDictionary() Initializes the object.
// - void addWord(word) Adds word to the data structure, it can be matched later.
// - bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isLast;
        TrieNode(){
            children = new TrieNode[26];
            isLast = false;
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            TrieNode curr = node.children[ch-'a'];
            if(curr == null){
                node.children[ch-'a'] = new TrieNode();
                curr = node.children[ch-'a'];
            }
            node = curr;
        }
        node.isLast = true;
    }
    
    public boolean search(String word) {
        return searchHelp(0, word, root);
    }

    private boolean searchHelp(int index, String word, TrieNode node){
        if(index == word.length()-1){
            if(word.charAt(index) == '.'){
                for(int i = 0; i<26; i++){
                    if(node.children[i] != null && node.children[i].isLast){
                        return true;
                    }
                }
                return false;
            }
            if(node.children[word.charAt(index)-'a'] != null && node.children[word.charAt(index)-'a'].isLast){
                return true;
            }
            return false;
        }

        if(word.charAt(index) == '.'){
            for(int i = 0; i<26; i++){
                if(node.children[i] != null && searchHelp(index+1, word, node.children[i])){
                    return true;
                }
            }
            return false;
        }

        if(node.children[word.charAt(index)-'a'] != null){
            return searchHelp(index+1, word, node.children[word.charAt(index) - 'a']);
        }

        return false;
    }
}
