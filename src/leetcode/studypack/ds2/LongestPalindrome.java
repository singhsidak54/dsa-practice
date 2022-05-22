package ds2;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] sArray = new int[128];
        for(int i=0; i<s.length(); i++) {
            sArray[s.charAt(i)]++;
        }

        for(int characterCount : sArray) {
            result += (characterCount / 2) * 2;
            if(result % 2 == 0 && characterCount % 2 == 1)
                result += 1;
        }
        return result;
    }
}
