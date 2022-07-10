package lc75l1;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] charArray = new int[128];
        for(int i=0; i<s.length(); i++) {
            charArray[s.charAt(i)]++;
        }

        int nEven = 0;
        boolean odd = false;

        for(int n : charArray) {
            nEven += n / 2;
            if(n % 2 > 0) {
                odd = true;
            }
        }

        return odd ? nEven * 2 + 1 : nEven * 2;
    }
}
