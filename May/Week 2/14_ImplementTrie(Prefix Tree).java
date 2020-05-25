/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.


*/ 

/* Completely new topic for me (implementation wise). Intuition has been derived from  LeetCode discussions pages */


class TrieNode {
    // R links to node children
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {    
    /* Initialize your data structure here. */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /* Inserts a word into the trie. */
    public void insert(String word) { 
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) node.put(currentChar, new TrieNode());

            node = node.get(currentChar);
        }
        
        node.setEnd();
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) node = node.get(curLetter);
           
           else return null;
        }
        
        return node;
    }
    
    /* Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
    
    /* Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:    //given as part of the question
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
 
