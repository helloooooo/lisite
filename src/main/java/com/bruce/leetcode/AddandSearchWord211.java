package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/6/28.
 */
public class AddandSearchWord211 {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));
    }
    static class WordDictionary{

        private TrieNode root;

        public WordDictionary(){
            root = new TrieNode();
        }
        //Adds a word into the data structure
        public void addWord(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.item = word;
        }
        //Returns if the word is in the data structure
        public boolean search(String word){
            return search(root, word);
        }

        public boolean search(TrieNode node, String target){
            if(target.length() == 0){
                if(node.item == "")
                    return false;
                else return true;
            }
            boolean ret = false;
            if(target.charAt(0) == '.'){
                for(int i = 0; i < 26; i++){
                    if(node.children[i] != null){
                        ret = ret || search(node.children[i], target.substring(1));
                    }
                }
                return ret;
            }
            else{
                if(node.children[target.charAt(0) - 'a'] == null){
                    return false;
                }
                else return search(node.children[target.charAt(0) - 'a'], target.substring(1));
            }
        }
    }
}
class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
    public TrieNode(){

    }
}
