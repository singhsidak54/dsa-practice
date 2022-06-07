package algo1;

// Problem Link - https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsInAStringIII {
    public static void reverseWord(char[] s, int l, int h) {
        while(l < h) {
            char temp = s[l];
            s[l] = s[h];
            s[h] = temp;
            l++;
            h--;
        }
    }

    public static String reverseWords(String s) {
        char[] temp = s.toCharArray();
        int wordStartIndex = 0;
        for(int i=0; i< temp.length; i++) {
            if(temp[i] == ' ') {
                reverseWord(temp, wordStartIndex, i - 1);
                wordStartIndex = i + 1;
            }
        }

        reverseWord(temp, wordStartIndex, temp.length - 1);

        return new String(temp);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("abc abc"));
    }
}
