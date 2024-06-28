package Scaler.String;

public class ReplicatingSubstring {
    public int solve(int A, String B) {
        int[] freq = new int[26];

        for(char c : B.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i] % A != 0) {
                return -1;
            }
        }
        return 1;
    }
}
