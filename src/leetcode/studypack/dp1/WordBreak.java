package dp1;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dictionary = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if(visited[idx]) continue;
            for(int i=idx; i<s.length(); i++) {
                if(dictionary.contains(s.substring(idx, i+1))) {
                    queue.add(i+1);
                    if(i+1 == s.length()) return true;
                }
            }
            visited[idx] = true;
        }

        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        int n = s.length();
        visited[s.length()] = true;
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<wordDict.size(); j++) {
                String dictWord = wordDict.get(j);
                int endIndex = i + dictWord.length();
                if(endIndex <= n && s.substring(i, endIndex).equals(dictWord) && visited[endIndex]) {
                    visited[i] = true;
                    break;
                }
            }
        }

        return visited[0];
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak2("leetcode", dict));
    }
}
