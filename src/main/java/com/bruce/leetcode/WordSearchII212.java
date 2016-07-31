package com.bruce.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 腾 on 2016/6/17.
 */
public class WordSearchII212 {
    class Solution{
        Set<String> res = new HashSet<String>();
        Trie trie = new Trie();

        public List<String> findWords(char[][] board, String[] words){
            //当对board进行dfs时产生的字符串找不到前缀树时，没必要继续往下执行了
            for(String s: words){
                trie.insert(s);
            }
            int m = board.length;
            if(m == 0)
                return new ArrayList<String>(res);
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n;j ++){
                    visited[i][j] = false;
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    dfs(board,i, j,visited,"");
                }
            }
            return new ArrayList<String>(res);
        }
        public void dfs(char[][] board, int i, int j, boolean[][] visited, String temp){
            if(i < 0 || i >= visited.length || j < 0 || j >= visited[0].length ||visited[i][j] == true)
                return;
            String val = temp + board[i][j];
            if(!trie.startsWith(val))
                return;
            if(trie.search(val))
                res.add(val);
            visited[i][j] = true;
            dfs(board, i+1, j, visited, val);
            dfs(board, i-1, j, visited, val);
            dfs(board,i,j+1, visited, val);
            dfs(board,i,j-1,visited,val);
            visited[i][j] = false;

        }
    }
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
        // Initialize your data structure here.
        public TrieNode() {

        }
    }
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null)
                    node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.item = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
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

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
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
