package companies.Bloomberg;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];

        for(int i=0; i<s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            tMap[t.charAt(i) - 'a']++;
        }

        int sameChars = 0;
        for(int i=0; i<26; i++) {
            sameChars += Math.min(sMap[i], tMap[i]);
        }

        return s.length() - sameChars;
    }
}
