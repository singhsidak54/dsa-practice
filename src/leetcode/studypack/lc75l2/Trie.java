package lc75l2;

public class Trie {
    private class TrieNode {

        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char c) {
            return this.links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return this.links[c - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean getEnd() {
            return this.isEnd;
        }

        public void put(char c, TrieNode node) {
            this.links[c - 'a'] = node;
        }
    }

    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }

        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
