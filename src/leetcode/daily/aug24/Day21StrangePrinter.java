package daily.aug24;

public class Day21StrangePrinter {
    public int helper(int start, int end, Integer[][] dp, String s) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != null) return dp[start][end];

        dp[start][end] = 1 + helper(start + 1, end, dp, s);

        for(int i=start+1; i<=end; i++) {
            if(s.charAt(i) == s.charAt(start)) {
                int currentTurns = helper(start, i - 1, dp, s) + helper(i + 1, end, dp, s);
                dp[start][end] = Math.min(dp[start][end], currentTurns);
            }
        }

        return dp[start][end];
    }
    public int strangePrinter(String s) {
        // remove duplicates
        StringBuilder noDuplicates = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            noDuplicates.append(s.charAt(i));
            while (i < s.length() && s.charAt(i) == noDuplicates.charAt(noDuplicates.length() - 1)) {
                i++;
            }
        }

        s = noDuplicates.toString();
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return helper(0, n - 1, dp, s);
    }

    public int strangePrinterTabulation(String s) {
        // remove duplicates
        StringBuilder noDuplicates = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            noDuplicates.append(s.charAt(i));
            while (i < s.length() && s.charAt(i) == noDuplicates.charAt(noDuplicates.length() - 1)) {
                i++;
            }
        }

        s = noDuplicates.toString();
        int n = s.length();
        int[][] dp = new int[n][n];

        // initialize all 1 character strings as 1
        for(int j=0; j<n; j++) {
            dp[j][j] = 1;
        }


        // start with length of 2 to n and calculate answer using sub problem solution
        for(int length=2; length<=n; length++) {
            for(int start=0; start+length-1<n; start++) {
                int end = start + length - 1;

                // initialize current ans as length because that's the worst case scenario if we print characters one by one
                dp[start][end] = length;

                // check turns required if we split string at various options available
                for(int split=start; split<end; split++) {
                    int turnsReq = dp[start][split] + dp[split+1][end];

                    // if char at split is equal to char at end, we can save one
                    if(s.charAt(split) == s.charAt(end)) {
                        turnsReq--;
                    }

                    dp[start][end] = Math.min(dp[start][end], turnsReq);
                }
            }
        }


        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "aabac";
        Day21StrangePrinter obj = new Day21StrangePrinter();
        System.out.println(obj.strangePrinterTabulation(s));
    }
}
