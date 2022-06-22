package misc;

public class TotalAppealOfAString {
    //Brute Force
    public static long appealSum(String s) {
        int n = s.length();
        long res = n;

        for(int length = 2; length <= n; length++) {
            for(int i=0; i+length<=n; i++) {
                res += countDistinct(s.substring(i, i + length));
            }
        }
        return res;
    }

    public static int countDistinct(String s) {
        int[] set = new int[26];
        int distinct = 0;
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(set[curr - 'a'] != 1) {
                distinct++;
                set[curr - 'a'] = 1;
            }
        }
        return distinct;
    }

    //dp
    public static long appealSum2(String s) {
        int n = s.length();
        long res = n;
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }

        for(int length = 2; length <= n; length++) {
            for(int i=0; i+length<=n; i++) {
                int endIndex = i + length - 1;
                if(!contains(s, i, endIndex, s.charAt(endIndex))) {
                    dp[i]++;
                }
                res += dp[i];
            }
        }
        return res;
    }

    public static boolean contains(String s, int low, int high, char c) {
        while (low < high) {
            if(s.charAt(low) == c) {
                return true;
            }
            low++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(appealSum("abbca"));
    }
}
