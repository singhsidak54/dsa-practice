package daily.oct24;

public class Day5PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] s1Map = new int[26], s2WindowMap = new int[26];
        int matchCount = 0;

        for(int i=0; i<s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2WindowMap[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(s1Map[i] == s2WindowMap[i]) matchCount++;
        }

        if(matchCount == 26) return true;

        for(int i=s1.length(); i<s2.length(); i++) {
            char toRemove = s2.charAt(i - s1.length()), toAdd = s2.charAt(i);

            if(s1Map[toRemove - 'a'] == s2WindowMap[toRemove - 'a']) matchCount--;
            s2WindowMap[toRemove - 'a']--;
            if(s1Map[toRemove - 'a'] == s2WindowMap[toRemove - 'a']) matchCount++;

            if(s1Map[toAdd - 'a'] == s2WindowMap[toAdd - 'a']) matchCount--;
            s2WindowMap[toAdd - 'a']++;
            if(s1Map[toAdd - 'a'] == s2WindowMap[toAdd - 'a']) matchCount++;

            if(matchCount == 26) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Day5PermutationInString obj = new Day5PermutationInString();
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));
    }
}
