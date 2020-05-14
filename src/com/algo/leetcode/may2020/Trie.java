package com.algo.leetcode.may2020;

import java.util.HashSet;

/*
 * Implement Trie (Prefix Tree)

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
public class Trie {
	//this will contain all the words
	HashSet<String> words;
	//this will contain all the prefixs for the added word
	HashSet<String> prefixs;
	
	/** Initialize your data structure here. */
    public Trie() {
    	words=new HashSet<>();
    	prefixs=new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	words.add(word);
    	
    	StringBuilder strBuilder=new StringBuilder();
    	for(int i=0; i<word.length(); i++) {
    		prefixs.add(strBuilder.append(word.charAt(i)).toString());
    	}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(words.contains(word))
        	return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(prefixs.contains(prefix))
        	return true;
        return false;
    }
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.search("apple");   // returns true
		trie.search("app");     // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");   
		trie.search("app");     // returns true
	}
}
