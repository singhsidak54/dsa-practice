package daily.apr23;

import java.util.Arrays;

public class Day23RestoreTheArray {

    int mod = 1_000_000_007;
    public int backtrack(String s, int k, int index, int[] dp) {
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;

        if(dp[index] != -1) return dp[index];

        long count = 0;

        int t = index;
        long curr = 0;
        while (index < s.length()) {
            curr = curr * 10 + (s.charAt(index) - '0');
            if(curr > k) break;

            count += backtrack(s, k, index + 1, dp);
            count = count % mod;
            index++;
        }

        dp[t] = (int)count;
        return dp[t];
    }

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return backtrack(s, k, 0, dp);
    }

    public static void main(String[] args) {
        Day23RestoreTheArray obj = new Day23RestoreTheArray();
        System.out.println(obj.numberOfArrays("600342244431311113256628376226052681059918526204", 703));
    }
}
