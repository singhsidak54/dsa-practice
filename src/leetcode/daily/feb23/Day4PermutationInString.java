package daily.feb23;

public class Day4PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i<s1.length(); i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }

        int matchCount = 0;
        for(int i=0; i<26; i++) {
            if(s1Map[i] == s2Map[i]) {
                matchCount++;
            }
        }

        if(matchCount == 26) return true;

        for(int i=s1.length(); i<s2.length(); i++) {
            char toRemove = s2.charAt(i - s1.length());
            char toAdd = s2.charAt(i);

            if(s1Map[toRemove - 'a'] == s2Map[toRemove - 'a']) {
                matchCount--;
            } else if (s1Map[toRemove - 'a'] == s2Map[toRemove - 'a'] - 1) {
                matchCount++;
            }
            s2Map[toRemove - 'a']--;

            s2Map[toAdd - 'a']++;
            if(s1Map[toAdd - 'a'] == s2Map[toAdd - 'a']) {
                matchCount++;
            } else if (s1Map[toAdd - 'a'] == s2Map[toAdd - 'a'] - 1) {
                matchCount--;
            }


            if(matchCount == 26) return true;
        }

        return false;
    }
}
