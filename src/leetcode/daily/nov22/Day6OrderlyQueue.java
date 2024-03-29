package daily.nov22;

import java.util.Arrays;

public class Day6OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if(k == 1) {
            String ans = s;
            for(int i=0; i<s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if(temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            return new String(sArray);
        }
    }
}
