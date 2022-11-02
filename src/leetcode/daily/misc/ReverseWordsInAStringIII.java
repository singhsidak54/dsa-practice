package daily.misc;

public class ReverseWordsInAStringIII {
    public void reverseWord(char[] sArray, int l, int h) {
        while(l < h) {
            char temp = sArray[l];
            sArray[l] = sArray[h];
            sArray[h] = temp;
            l++;
            h--;
        }
    }

    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        int start = 0, i = 0;
        while (i < s.length()) {
            if(Character.isWhitespace(sArray[i])) {
                reverseWord(sArray, start, i);
                start = i + 1;
            }
            i++;
        }

        reverseWord(sArray, start, i-1);
        return new String(sArray);
    }
}
