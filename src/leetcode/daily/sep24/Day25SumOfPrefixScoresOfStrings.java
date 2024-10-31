package daily.sep24;

import java.util.Arrays;

public class Day25SumOfPrefixScoresOfStrings {
    class Node {
        Node[] level;
        int count;
        public Node() {
            this.level = new Node[27];
            this.count = 0;
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
                curr.count++;
                idx++;
            }
            // mark ending of a word
            curr.level[26] = new Node();
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie(words);
        int[] ans = new int[words.length];
        for(int i=0; i<words.length; i++) {
            int sumOfPrefixScore = 0;
            Node curr = trie.root;
            for(int j=0; j<words[i].length(); j++) {
                int charIndex = words[i].charAt(j) - 'a';
                curr = curr.level[charIndex];
                sumOfPrefixScore += curr.count;
                if (curr.count == 1) {
                    sumOfPrefixScore += words[i].length() - j - 1;
                    break;
                }
            }

            ans[i] = sumOfPrefixScore;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day25SumOfPrefixScoresOfStrings obj = new Day25SumOfPrefixScoresOfStrings();
        String[] words = {"abc","ab","bc","b"};
        System.out.println(Arrays.toString(obj.sumPrefixScores(words)));
    }
}
