package daily.apr23;

public class Day14LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
        }

        for(int len=2; len<=n; len++) {
            for(int i=0; i+len-1<n; i++) {
                int lastIdx = i + len - 1;
                if(s.charAt(i) == s.charAt(lastIdx)) {
                    dp[i][lastIdx] = dp[i+1][lastIdx - 1] + 2;
                } else {
                    int optionA = i == n - 1 ? 0 : dp[i+1][lastIdx];
                    int optionB = dp[i][lastIdx - 1];
                    dp[i][lastIdx] = Math.max(optionA, optionB);
                }

            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Day14LongestPalindromicSubsequence obj = new Day14LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
    }
}
