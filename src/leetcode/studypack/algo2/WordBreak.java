package algo2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {
    public boolean wordBreakDPBottomUp(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[s.length()] = true;

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<wordDict.size(); j++) {
                String dictWord = wordDict.get(j);
                int endIndex = i + dictWord.length();
                if(endIndex <= n && s.substring(i, endIndex).equals(dictWord) && dp[endIndex]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean wordBreakDPTopDown(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if(visited[i]) {
                continue;
            }
            for(int j=i; j<n; j++) {
                if(set.contains(s.substring(i, j+1))) {
                    queue.add(j+1);
                    if(j+1 == n) {
                        return true;
                    }
                }
            }
            visited[i] = true;
        }
        return false;
    }

}
