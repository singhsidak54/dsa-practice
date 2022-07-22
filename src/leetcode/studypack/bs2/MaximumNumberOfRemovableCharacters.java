package bs2;

import java.util.Arrays;

public class MaximumNumberOfRemovableCharacters {
    public static boolean isSubsequence(char[] s, String p) {
        int i=0, j=0;
        while (i < s.length && j < p.length()) {
            if(s[i] == p.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == p.length();

    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, h = removable.length, m;
        char[] sArray;
        while (l < h) {
            sArray = s.toCharArray();
            m = h - (h-l)/2;
            for(int i=0; i<m; i++) {
                sArray[removable[i]] = '/';
            }

            if(isSubsequence(sArray, p)) {
                l = m;
            } else {
                h = m-1;
            }
        }

        return l;
    }


    public static int maximumRemovals2(String s, String p, int[] removable) {
        int l = 0, r = removable.length, m;
        int[] map = new int[s.length()];
        Arrays.fill(map, removable.length);
        for(int i=0; i<removable.length; i++) {
            map[removable[i]] = i;
        }

        while (l < r) {
            m = r - (r - l)/2;
            int j = 0;
            for(int i=0; i<s.length() && j<p.length(); i++) {
                if(map[i] >= m && s.charAt(i) == p.charAt(j)) {
                    j++;
                }
            }

            if(j == p.length()) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(maximumRemovals2("qlevcvgzfpryiqlwy", "qlecfqlw", new int[] {12,5}));
    }
}