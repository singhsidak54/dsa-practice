package daily.mar23;

public class Day17ImplementTrie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;

        public TrieNode() {
            this.nodes = new TrieNode[26];
            this.isEnd = false;
        }
    }

    TrieNode root;
    public Day17ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int i = 0;
        while (i < word.length()) {
            int idx = word.charAt(i) - 'a';
            if(node.nodes[idx] == null) {
                node.nodes[idx] = new TrieNode();
            }

            node = node.nodes[idx];
            i++;
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        int i = 0;
        while (i < word.length()) {
            int idx = word.charAt(i) - 'a';
            if(node.nodes[idx] == null) {
                return false;
            }

            node = node.nodes[idx];
            i++;
        }

        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int i = 0;
        while (i < prefix.length()) {
            int idx = prefix.charAt(i) - 'a';
            if(node.nodes[idx] == null) {
                return false;
            }

            node = node.nodes[idx];
            i++;
        }

        return true;
    }
}
