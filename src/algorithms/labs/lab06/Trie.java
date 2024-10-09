package algorithms.labs.lab06;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {

    class TrieNode{
        TrieNode[] dictionary;
        boolean eow;
        TrieNode(){
            dictionary = new TrieNode[26];
            eow=false;
        }
    }

    TrieNode[] dictionary;

    public Trie() {
        // only small letters are considered
        this.dictionary = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode currentNode = dictionary[word.charAt(0)-'a'];
        if(currentNode == null){
            currentNode = new TrieNode();
            dictionary[word.charAt(0)-'a'] = currentNode;
        }

        for(int i=1;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = currentNode.dictionary[c-'a'];
            if(node != null){
                currentNode = node;
            }else{
                TrieNode n = new TrieNode();
                currentNode.dictionary[c-'a'] = n;
                currentNode = n;
            }
        }
        currentNode.eow = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = dictionary[word.charAt(0) - 'a'];
        if(currentNode == null) return false;

        for(int i=1;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = currentNode.dictionary[c-'a'];
            if(node != null){
                currentNode = node;
            }else{
                return false;
            }
        }
        return currentNode.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = dictionary[prefix.charAt(0) - 'a'];
        if(currentNode == null) return false;

        for(int i=1;i<prefix.length();i++){
            char c = prefix.charAt(i);
            TrieNode node = currentNode.dictionary[c-'a'];
            if(node != null){
                currentNode = node;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
         Trie obj = new Trie();
         obj.insert("hello");
         boolean param_2 = obj.search("hello");
        System.out.println(param_2);
         boolean param_3 = obj.startsWith("hell");
        System.out.println(param_3);
    }
}
