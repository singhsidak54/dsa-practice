package Scaler.Hashing;

import java.util.HashMap;

public class WindowString {
    public String minWindow(String A, String B) {
        if(B.length() > A.length()) return "";
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c : B.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int reqMatch = freqMap.size(), currentMatch = 0;
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int ptr = 0;

        while (ptr < B.length()) {
            char c = A.charAt(ptr++);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if(windowMap.get(c).equals(freqMap.get(c))) {
                currentMatch++;
            }
        }

        if(currentMatch == reqMatch) {
            minLen = B.length();
            ans = A.substring(0, minLen);
        }

        int start = 0;
        while (ptr < A.length()) {
            char in = A.charAt(ptr);

            windowMap.put(in, windowMap.getOrDefault(in, 0) + 1);
            if(windowMap.get(in).equals(freqMap.getOrDefault(in, 0))) {
                currentMatch++;
            }

            while (currentMatch == reqMatch) {
                char out = A.charAt(start++);
                if(windowMap.get(out).equals(freqMap.getOrDefault(out, 0))) {
                    currentMatch--;
                }

                windowMap.put(out, windowMap.get(out) - 1);

                if(currentMatch == reqMatch && ptr - start + 1 < minLen) {
                    minLen = ptr - start + 1;
                    ans = A.substring(start, ptr + 1);
                }
            }
            ptr++;
        }

        return ans;
    }
}
