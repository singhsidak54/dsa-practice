package lc75l2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        HashMap<Character, Integer> sWindowCharMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tCharMap.put(c, tCharMap.getOrDefault(c, 0) + 1);
        }

        int done = 0, currAns = -1, l = -1, r = -1, currL = 0, currR = 0, req = tCharMap.keySet().size();
        while (currR < s.length()) {
            char c = s.charAt(currR);

            if(tCharMap.containsKey(c)) {
                sWindowCharMap.put(c, sWindowCharMap.getOrDefault(c, 0) + 1);
                if(sWindowCharMap.get(c).intValue() == tCharMap.get(c).intValue()) {
                    done++;
                }
            }

            while (currL <= currR && done == req) {
                if(currAns == -1 || currR - currL + 1 < currAns) {
                    currAns = currR - currL + 1;
                    l = currL;
                    r = currR;
                }

                char temp = s.charAt(currL);
                if(tCharMap.containsKey(temp)) {
                    sWindowCharMap.put(temp, sWindowCharMap.get(temp) - 1);
                    if(sWindowCharMap.get(temp) < tCharMap.get(temp)) {
                        done--;
                    }
                }
                currL++;
            }
            currR++;
        }

        return currAns == -1 ? "" : s.substring(l, r + 1);
    }

    class Node {
        int index;
        char c;

        public Node(int index, char c) {
            this.c = c;
            this.index = index;
        }
    }

    public String minWindowOptimised(String s, String t) {
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        HashMap<Character, Integer> sWindowCharMap = new HashMap<>();

        for(char c : t.toCharArray()) {
            tCharMap.put(c, tCharMap.getOrDefault(c, 0) + 1);
        }

        List<Node> nodes = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(tCharMap.containsKey(c)) {
                nodes.add(new Node(i, c));
            }
        }
        int done = 0, req = tCharMap.size();
        int currAns = -1, l = 0, r = 0, cL = 0, cR = 0;
        while (cR < nodes.size()) {
            char c = nodes.get(cR).c;

            if(tCharMap.containsKey(c)) {
                sWindowCharMap.put(c, sWindowCharMap.getOrDefault(c, 0) + 1);

                if(sWindowCharMap.get(c).intValue() == tCharMap.get(c).intValue()) {
                    done++;
                }
            }

            while (cL <= cR && done == req) {
                c = nodes.get(cL).c;
                int end = nodes.get(cR).index;
                int start = nodes.get(cL).index;

                if(currAns == -1 || end - start + 1 < currAns) {
                    currAns = end - start + 1;
                    l = start;
                    r = end;
                }

                sWindowCharMap.put(c, sWindowCharMap.get(c) - 1);
                if(sWindowCharMap.get(c) < tCharMap.get(c)) {
                    done--;
                }
                cL++;
            }
            cR++;
        }

        return currAns == -1 ? "" : s.substring(l, r + 1);
    }
}
