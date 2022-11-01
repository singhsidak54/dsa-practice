package daily.oct22;

public class Day10BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }

        char[] brokenPalindrome = palindrome.toCharArray();
        int i = 0, n = palindrome.length();
        while (i < n/2) {
            if(brokenPalindrome[i] != 'a') {
                brokenPalindrome[i] = 'a';
                return new String(brokenPalindrome);
            }
            i++;
        }

        brokenPalindrome[n - 1] = 'b';
        return new String(brokenPalindrome);
    }
}
