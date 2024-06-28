package daily.mar23;

public class Day19WordDictionary {

    class Node {
        Node[] links;
        boolean isWord;

        public Node() {
            this.links = new Node[26];
            this.isWord = false;
        }
    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for(int i=0; i<word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.links[idx] == null) {
                    node.links[idx] = new Node();
                }

                node = node.links[idx];
            }

            node.isWord = true;
        }

        public boolean search(Node node, String word, int index) {
            if(index == word.length() && node.isWord) {
                return true;
            }

            for(int i=index; i<word.length(); i++) {
                char c = word.charAt(i);
                if(c == '.') {
                    for(int j=0; j<26; j++) {
                        if(node.links[j] != null && search(node.links[j], word, i + 1)) {
                            return true;
                        }
                    }

                    return false;
                } else {
                    int idx = c - 'a';
                    if(node.links[idx] == null) {
                        return false;
                    }

                    node = node.links[idx];
                }
            }

            return node.isWord;
        }
    }

    Trie trie;
    public Day19WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        this.trie.addWord(word);
    }

    public boolean search(String word) {
        return this.trie.search(this.trie.root, word, 0);
    }

    public static void main(String[] args) {
        Day19WordDictionary obj = new Day19WordDictionary();
        obj.addWord("a");
        obj.addWord("a");
        System.out.println(obj.search("."));
        System.out.println(obj.search("a"));
        System.out.println(obj.search("aa"));
        System.out.println(obj.search("a"));
        System.out.println(obj.search(".a"));
        System.out.println(obj.search("a."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
