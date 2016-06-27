package com.bruce.leetcode;

/**
 * Created by 腾 on 2016/6/17.
 */
public class ImplementTrie208 {

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
        public TrieNode(){

        }
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        //insert a word into the trie
        public void insert(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.item = word;
        }
        //returns if the word is in the trie
        public boolean search(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null)
                    return false;
                else{
                    node = node.children[c-'a'];
                }
            }
            if(node.item.equals(word))
                return true;
            else  return false;
        }

        //returns if there is any word in the trie
        //that starts with the given prefix
        public boolean startsWith(String prefix){
            TrieNode node = root;
            for(char c: prefix.toCharArray()){
                if(node.children[c-'a'] == null)
                    return false;
                else{
                    node = node.children[c-'a'];
                }
            }
            return true;
        }
    }
}
