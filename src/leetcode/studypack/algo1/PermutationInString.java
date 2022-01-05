package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    public static boolean matches(int[] s1Map, int[] s2Map) {
        for(int i=0; i<26; i++) {
            if(s1Map[i] != s2Map[i])
                return false;
        }

        return true;
    }

    public boolean checkInclusionSol4(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        for(int i=0; i<s1.length(); i++) {
            int charIndex = s1.charAt(i) - 'a';
            s1Map[charIndex]++;
        }

        for(int i=0; i<=s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for(int j=0; j<s1.length(); j++) {
                int charIndex = s2.charAt(i + j) - 'a';
                s2Map[charIndex]++;
            }

            if(matches(s1Map,s2Map))
                return true;
        }

        return false;
    }

    public static boolean checkInclusionSol5(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i=0; i<s1.length(); i++) {
            int s1CharIndex = s1.charAt(i) - 'a';
            int s2CharIndex = s2.charAt(i) - 'a';
            s1Map[s1CharIndex]++;
            s2Map[s2CharIndex]++;
        }

        for(int i=0; i<s2.length()-s1.length(); i++) {
            if(matches(s1Map, s2Map))
                return true;

            int s2RemoveCharIndex = s2.charAt(i) - 'a';
            int s2AddCharIndex = s2.charAt(s1.length() + i) - 'a';

            s2Map[s2RemoveCharIndex]--;
            s2Map[s2AddCharIndex]++;
        }
        return matches(s1Map, s2Map);
    }

    public static boolean checkInclusionSol6(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i=0; i<s1.length(); i++) {
            int s1CharIndex = s1.charAt(i) - 'a';
            int s2CharIndex = s2.charAt(i) - 'a';
            s1Map[s1CharIndex]++;
            s2Map[s2CharIndex]++;
        }

        int matchingCount = 0;
        for(int i=0; i<26; i++) {
            if(s1Map[i] == s2Map[i])
                matchingCount++;
        }

        for(int i=0; i<s2.length()-s1.length(); i++) {
            if(matchingCount == 26)
                return true;

            int s2RemoveCharIndex = s2.charAt(i) - 'a';
            int s2AddCharIndex = s2.charAt(s1.length() + i) - 'a';

            s2Map[s2RemoveCharIndex]--;
            if(s2Map[s2RemoveCharIndex] == s1Map[s2RemoveCharIndex])
                matchingCount++;
            else if(s2Map[s2RemoveCharIndex] == s1Map[s2RemoveCharIndex] - 1)
                matchingCount--;

            s2Map[s2AddCharIndex]++;
            if(s2Map[s2AddCharIndex] == s1Map[s2AddCharIndex])
                matchingCount++;
            else if(s2Map[s2AddCharIndex] == s1Map[s2AddCharIndex] + 1)
                matchingCount--;
        }

        return matchingCount == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusionSol6("adc", "dcda"));
    }
}
