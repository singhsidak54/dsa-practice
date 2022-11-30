package daily.nov22;

import java.util.*;

public class Day5WordSearchII {

    static class TrieNode {
        TrieNode[] links;
        boolean isEnd;
        String word;
        public TrieNode () {
            this.links = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;
        public Trie () {
            this.root = new TrieNode();
        }

        public void insertWord(String word) {
            TrieNode node = this.root;
            for(int i=0; i<word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(node.links[idx] == null) {
                    node.links[idx] = new TrieNode();
                }
                node = node.links[idx];
            }

            node.isEnd = true;
            node.word = word;
        }
    }

    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static void findWordHelper(char[][] board, TrieNode node, int row, int col, List<String> result) {
        if(node == null) return;
        if(node.isEnd) {
            result.add(node.word);
            node.isEnd = false;
        }
        if(!isValid(board.length, board[0].length, row, col) || board[row][col] == '#') return;

        char c = board[row][col];
        TrieNode next = node.links[c - 'a'];
        board[row][col] = '#';
        findWordHelper(board, next, row + 1, col, result);
        findWordHelper(board, next, row, col + 1, result);
        findWordHelper(board, next, row - 1, col, result);
        findWordHelper(board, next, row, col - 1, result);
        board[row][col] = c;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for(String word : words) {
            trie.insertWord(word);
        }

        List<String> result = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                findWordHelper(board, trie.root, i, j, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath", "eat"};
        System.out.println(findWords(board, words));
    }
}
