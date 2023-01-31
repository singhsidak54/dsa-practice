package companies.Bloomberg;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Set<Character> seen = new HashSet<>();
        HashMap<Character, List<Character>> charGreaterMap = new HashMap<>();

        for(int i=0; i<words[0].length(); i++) {
            seen.add(words[0].charAt(i));
        }

        for(int i=1; i<words.length; i++) {
            String previous = words[i-1];
            String current = words[i];


            int j = 0, max = Math.min(previous.length(), current.length());
            while (j < max && previous.charAt(j) == current.charAt(j)) {
                seen.add(current.charAt(j));
                j++;
            }

            for(int k=j; k<current.length(); k++) {
                seen.add(current.charAt(k));
            }

            if(j == max && j < previous.length()) return "";
            if(j == max) continue;

            for(int k=j; k<previous.length(); k++) {
                seen.add(previous.charAt(k));
            }

            seen.add(current.charAt(j));
            seen.add(previous.charAt(j));
            inDegree[current.charAt(j) - 'a']++;
            List<Character> neighbourArray = charGreaterMap.getOrDefault(previous.charAt(j), new ArrayList<>());
            neighbourArray.add(current.charAt(j));
            charGreaterMap.put(previous.charAt(j), neighbourArray);
        }

        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(char c='a'; c<='z'; c++) {
            if(seen.contains(c) && inDegree[c - 'a'] == 0) {
                queue.add(c);
                seen.remove(c);
            }
        }


        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for(char c : charGreaterMap.getOrDefault(curr, new ArrayList<>())) {
                inDegree[c - 'a']--;
                if(inDegree[c - 'a'] == 0) {
                    queue.add(c);
                    seen.remove(c);
                }
            }
        }


        return seen.isEmpty() ? result.toString() : "";
    }
}
