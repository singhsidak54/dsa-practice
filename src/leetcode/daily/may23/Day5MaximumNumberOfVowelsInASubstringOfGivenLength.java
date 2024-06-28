package daily.may23;

public class Day5MaximumNumberOfVowelsInASubstringOfGivenLength {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int start = 0, end = 0, max = 0, count = 0;
        while (end < k) {
            if(isVowel(s.charAt(end))) {
                count++;
            }
            end++;
        }

        max = count;

        while (end < s.length()) {
            if(isVowel(s.charAt(start))) {
                count--;
            }

            if(isVowel(s.charAt(end))) {
                count++;
            }

            max = Math.max(max, count);

            start++;
            end++;
        }

        return max;
    }
}
