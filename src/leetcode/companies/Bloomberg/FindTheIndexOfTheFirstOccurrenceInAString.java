package companies.Bloomberg;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int i = 0;
        while (i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int start = i, needlePtr = 0;
                while (needlePtr < needle.length() && start < haystack.length() && haystack.charAt(start) == needle.charAt(needlePtr)) {
                    needlePtr++;
                    start++;
                }

                if(needlePtr == needle.length()) return i;
            }
            i++;
        }

        return -1;
    }
}
