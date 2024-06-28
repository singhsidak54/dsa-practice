package Scaler.Contest.AdvancedDSA2;

public class Q3 {
    public static int solve(String A, int[] B, int C) {
        int windowSpecial = 0, start = 0, end = 0;
        int maxLen = 0;
        while (end < A.length()) {
            char c = A.charAt(end);
            if(B[c - 'a'] == 1) {
                windowSpecial++;
            }

            while (windowSpecial > C) {
                char s = A.charAt(start);
                if(B[s - 'a'] == 1) {
                    windowSpecial--;
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String test = "hqghumeaylnlfdxf";
        int[] a = {0,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,1,1,0};
        System.out.println(solve(test, a, 14));
    }
}
