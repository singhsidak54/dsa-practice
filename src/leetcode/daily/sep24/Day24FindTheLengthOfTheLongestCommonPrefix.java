package daily.sep24;


public class Day24FindTheLengthOfTheLongestCommonPrefix {
    class Trie {
        class Node {
            Node[] level;
            public Node() {
                this.level = new Node[10];
            }
        }

        Node root;

        public Trie(int[] nums) {
            this.root = new Node();
            for(int num : nums) {
                this.put(num);
            }
        }

        public void put(int num) {
            Node curr = root;
            String nStr = String.valueOf(num);
            int idx = 0;
            while (idx < nStr.length()) {
                int digit = nStr.charAt(idx) - '0';
                if (curr.level[digit] == null) curr.level[digit] = new Node();
                curr = curr.level[digit];
                idx++;
            }
        }

        public int findPrefix(int num) {
            int prefix = 0, idx = 0;
            String nStr = String.valueOf(num);
            Node curr = root;
            while (idx < nStr.length() && curr != null) {
                int digit = nStr.charAt(idx) - '0';
                if (curr.level[digit] == null) break;
                prefix++;
                curr = curr.level[digit];
                idx++;
            }

            return prefix;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;
        Trie trie = new Trie(arr1);
        for (int num : arr2) {
            int prefix = trie.findPrefix(num);
            longestPrefix = Math.max(longestPrefix, prefix);
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100}, arr2 = {1000};
        Day24FindTheLengthOfTheLongestCommonPrefix obj = new Day24FindTheLengthOfTheLongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(arr1, arr2));
    }
}
