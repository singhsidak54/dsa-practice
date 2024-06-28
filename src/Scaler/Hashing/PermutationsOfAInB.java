package Scaler.Hashing;

public class PermutationsOfAInB {
    public int solve(String A, String B) {
        if(A.length() > B.length()) return 0;
        int[] aMap = new int[26];
        int[] bWindowMap = new int[26];

        for(int i=0; i<A.length(); i++) {
            aMap[A.charAt(i) - 'a']++;
            bWindowMap[B.charAt(i) - 'a']++;
        }

        int ans = 0, matchCount = 0;
        for(int i=0; i<26; i++) {
            if(aMap[i] == bWindowMap[i]) matchCount++;
        }

        if(matchCount == 26) ans++;

        int start = 0, end = A.length();
        while (end < B.length()) {
            char out = B.charAt(start++);
            char in = B.charAt(end++);

            bWindowMap[out - 'a']--;
            bWindowMap[in - 'a']++;

            for(int i=0; i<26; i++) {
                if(aMap[i] == bWindowMap[i]) matchCount++;
            }

            if(matchCount == 26) ans++;
        }

        return ans;
    }
}
