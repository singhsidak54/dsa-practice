package daily.mar23;

public class Day3FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        for(int i=0; i<haystack.length() - needle.length(); i++) {
            int k = 0;
            while (k < needle.length() && haystack.charAt(i + k) == needle.charAt(k)) {
                k++;
            }

            if(k == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
