package daily.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    class Node {
        char c;
        int index;
        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sWindowMap = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        List<Node> trimmedS = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(tMap.containsKey(s.charAt(i))) {
                trimmedS.add(new Node(s.charAt(i), i));
            }
        }

        if(trimmedS.size() == 0) return "";

        int start = 0, end = Integer.MAX_VALUE;
        int matchCount = 0, reqMatchCount = tMap.keySet().size();
        int i=0, currStart = 0;
        while (i < trimmedS.size()) {
            Node curr = trimmedS.get(i);
            sWindowMap.put(curr.c, sWindowMap.getOrDefault(curr.c, 0) + 1);

            if(sWindowMap.get(curr.c).equals(tMap.get(curr.c))) {
                matchCount++;
            }

            while (matchCount == reqMatchCount) {
                Node node = trimmedS.get(currStart);

                if(curr.index - node.index < end - start) {
                    end = curr.index;
                    start = node.index;
                }

                sWindowMap.put(node.c, sWindowMap.getOrDefault(node.c, 0) - 1);
                if(sWindowMap.get(node.c).equals(tMap.get(node.c) - 1)) {
                    matchCount--;
                }

                currStart++;
            }

            i++;
        }

        return end == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}
