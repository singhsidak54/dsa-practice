package lc75l1;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int maxCount = 0, start = 0, result = 0;

        for(int end=0; end<s.length(); end++) {
            charCount[s.charAt(end) - 'A']++;
            if(charCount[s.charAt(end) - 'A'] > maxCount) {
                maxCount = charCount[s.charAt(end) - 'A'];
            }

            if(end - start + 1 - maxCount > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }

            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}
