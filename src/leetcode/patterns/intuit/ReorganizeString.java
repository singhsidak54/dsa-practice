package patterns.intuit;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        int max = 0;
        char maxChar = 'a';
        for(int i=0; i<26; i++) {
            if(charCount[i] > max) {
                max = charCount[i];
                maxChar = (char)('a' + i);
            }
        }

        if(max > (s.length() + 1)/2) {
            return "";
        }

        char[] result = new char[s.length()];
        int idx = 0;
        while (charCount[maxChar - 'a'] > 0) {
            result[idx] = maxChar;
            idx += 2;
            charCount[maxChar - 'a']--;
        }

        for(int i=0; i<26; i++) {
            while (charCount[i] > 0) {
                if(idx >= s.length()) {
                    idx = 1;
                }
                result[idx] = (char)(i + 'a');
                idx += 2;
                charCount[i]--;
            }
        }

        return new String(result);
    }
}
