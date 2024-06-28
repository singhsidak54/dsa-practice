package Scaler.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public boolean canBreak(String A, int index, Set<String> words, int[] dp) {
        if(index == A.length()) return true;

        if(dp[index] == -1) return false;

        StringBuilder word = new StringBuilder();
        for(int i=index; i<A.length(); i++) {
            word.append(A.charAt(i));
            if(words.contains(word.toString()) && canBreak(A, i + 1, words, dp)) return true;
        }

        dp[index] = -1;
        return false;
    }
    public int wordBreak(String A, String[] B) {
        Set<String> dict = new HashSet<>(Arrays.asList(B));
        return canBreak(A, 0, dict, new int[A.length()]) ? 1 : 0;
    }
}
