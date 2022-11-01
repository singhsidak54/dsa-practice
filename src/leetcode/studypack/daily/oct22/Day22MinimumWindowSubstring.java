package daily.oct22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day22MinimumWindowSubstring {
    class Node {
        char c;
        int index;
        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sWindowMap = new HashMap<>();
        List<Node> filteredS = new ArrayList<>();

        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<s.length(); i++) {
            if(!tMap.containsKey(s.charAt(i))) continue;

            filteredS.add(new Node(s.charAt(i), i));
        }

        if(filteredS.size() == 0) return "";

        int maxLen = Integer.MAX_VALUE, start = -1, end = -1, matchReq = tMap.size(), currentMatch = 0;
        int currStart = 0, currEnd = 0;
        while (currEnd < filteredS.size()) {
            char c = filteredS.get(currEnd).c;

            sWindowMap.put(c, sWindowMap.getOrDefault(c, 0) + 1);
            if(sWindowMap.get(c).equals(tMap.get(c))) {
                currentMatch++;
            }

            while (currentMatch == matchReq) {
                int currAns = filteredS.get(currEnd).index - filteredS.get(currStart).index;
                if(currAns < maxLen) {
                    maxLen = currAns;
                    start = currStart;
                    end = currEnd;
                }

                char currStartChar = filteredS.get(currStart).c;
                sWindowMap.put(currStartChar, sWindowMap.get(currStartChar) - 1);
                currStart++;

                if(sWindowMap.get(currStartChar) < tMap.get(currStartChar)) {
                    currentMatch--;
                }
            }
            currEnd++;
        }

        return start == -1 ? "" : s.substring(filteredS.get(start).index, filteredS.get(end).index + 1);
    }
}
