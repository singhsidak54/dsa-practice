package Scaler.String;

import java.util.HashSet;
import java.util.Set;

public class BoringSubstring {
    public static int solve(String A) {
        Set<Character> odd = new HashSet<>();
        Set<Character> even = new HashSet<>();

        for(char c : A.toCharArray()) {
            int idx = c - 'a';
            if(idx % 2 == 0) {
                even.add(c);
            } else {
                odd.add(c);
            }
        }

        if(odd.size() == 0 || even.size() == 0) return 1;

        Character oddSm = null, oddLa = null, evenSm = null, evenLa = null;
        for(char c : odd) {
            if(oddSm == null || oddSm > c) {
                oddSm = c;
            }

            if(oddLa == null || oddLa < c) {
                oddLa = c;
            }
        }

        for(char c : even) {
            if(evenSm == null || evenSm > c) {
                evenSm = c;
            }

            if(evenLa == null || evenLa < c) {
                evenLa = c;
            }
        }

        boolean sm_sm = Math.abs(oddSm - evenSm) != 1;
        boolean la_la = Math.abs(oddLa - evenLa) != 1;
        boolean sm_la = Math.abs(oddSm - evenLa) != 1;
        boolean la_sm = Math.abs(oddLa - evenSm) != 1;

        return (sm_sm || sm_la || la_la || la_sm) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solve("aab"));
    }
}
