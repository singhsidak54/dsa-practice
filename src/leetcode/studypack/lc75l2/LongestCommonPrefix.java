package lc75l2;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (true) {
            if(i == strs[0].length()) {
                return strs[0].substring(0, i);
            }

            char curr = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != curr) {
                    return strs[j].substring(0, i);
                }
            }
            i++;
        }
    }

    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        int i=0, maxIndex = Math.min(strs[0].length(), strs[n-1].length());
        for (; i<maxIndex; i++) {
            if(strs[0].charAt(i) != strs[n-1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }

        return i == maxIndex ? strs[0].substring(0, maxIndex) : "";
    }
}
