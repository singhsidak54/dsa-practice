package daily.sep24;

import java.util.Arrays;

public class Day23ExtraCharactersInAString {
    class Node {
        Node[] level;
        public Node() {
            this.level = new Node[27];
        }
    }

    class Trie {
        Node root;
        public Trie(String[] dictionary) {
            this.root = new Node();
            for (String word : dictionary) {
                this.put(word);
            }
        }

        public void put(String word) {
            Node curr = root;
            int idx = 0;
            while (idx < word.length()) {
                int charIndex = word.charAt(idx) - 'a';
                if (curr.level[charIndex] == null) curr.level[charIndex] = new Node();
                curr = curr.level[charIndex];
                idx++;
            }
            // mark ending of a word
            curr.level[26] = new Node();
        }

        public boolean find(StringBuilder word) {
            Node curr = root;
            int idx = 0;
            while (idx < word.length() && curr != null) {
                int charIndex = word.charAt(idx) - 'a';
                if (curr.level[charIndex] == null) return false;
                curr = curr.level[charIndex];
                idx++;
            }

            return curr != null && curr.level[26] != null;
        }
    }

    public int dfs(String s, int idx, Trie trie, int[] dp) {
        if (idx == s.length()) return 0;
        if (dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        for(int i=idx; i<s.length(); i++) {
            str.append(s.charAt(i));
            boolean contains = trie.find(str);

            // if contains, we can split and look further
            if (contains) {
                ans = Math.min(ans, dfs(s, i + 1, trie, dp));
            }
        }

        ans = Math.min(ans, 1 + dfs(s, idx + 1, trie, dp));;
        dp[idx] = ans;
        return dp[idx];
    }

    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie(dictionary);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, trie, dp);
    }

    public static void main(String[] args) {
        String[] dictionary = {"hello","world"};
        Day23ExtraCharactersInAString obj = new Day23ExtraCharactersInAString();
        System.out.println(obj.minExtraChar("sayhelloworld", dictionary));
    }
}
