package daily.jan23;

import java.util.ArrayList;
import java.util.List;

public class Day22PalindromePartitioning {

    List<List<String>> result;
    boolean[][] dp;

    public void dfs(String s, int index, List<String> curr) {
        if(index == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        StringBuilder palindrome = new StringBuilder();
        for(int i=index; i<s.length(); i++) {
            palindrome.append(s.charAt(i));
            if(dp[index][i]) {
                curr.add(palindrome.toString());
                dfs(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        // one length
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        // two length
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
            }
        }

        // 2 to n length
        for(int length=2; length<n; length++) {
            for(int i=0; i+length<n; i++) {
                if(s.charAt(i) == s.charAt(i+length) && dp[i+1][i+length-1]) {
                    dp[i][i+length] = true;
                }
            }
        }


        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return result;
    }
}
