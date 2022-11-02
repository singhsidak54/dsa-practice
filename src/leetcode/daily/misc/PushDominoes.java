package daily.misc;

import java.util.Arrays;

public class PushDominoes {

    public static String pushDominoes(String dominoes) {
        char[] dominoesArray = dominoes.toCharArray();
        int[] force = new int[dominoes.length()];
        int currF = 0;

        for(int i=0; i<dominoesArray.length; i++) {
            char c = dominoesArray[i];
            if(c == 'R') {
                currF = 1;
            } else if(c == 'L') {
                currF = -1;
            } else if (c == '.') {
                currF = 0;
            }

            force[i] = currF;
        }

        int currR = 0;
        for(int i=0; i<dominoesArray.length; i++) {
            if(force[i] == 1) {
                currR = 1;
            } else if (force[i] == 0 && currR != 0) {
                currR++;
            } else if (force[i] == -1) {
                currR = 0;
            }

            if(currR >= 1) {
                dominoesArray[i] = 'R';
                force[i] = currR;
            }
        }

        int currL = 0;
        for(int i=dominoesArray.length-1; i>=0; i--) {
            if(force[i] == -1) {
                currL = -1;
            } else if (force[i] == 0 && currL < 0) {
                currL--;
            } else if (force[i] == 1) {
                currL = 0;
            }  else if (currL < 0 && force[i] > 1) {
                currL--;
                if(Math.abs(currL) < force[i]) {
                    force[i] = currL;
                } else if (Math.abs(currL) == force[i]) {
                    force[i] = 0;
                    currL = 0;
                    dominoesArray[i] = '.';
                } else {
                    currL = 0;
                }
            }

            if(force[i] <= 0 && currL < 0) {
                dominoesArray[i] = 'L';
            }
        }

        return new String(dominoesArray);
    }

    public static String pushDominoesQuality(String dominoes) {
        int n = dominoes.length();
        int[] force = new int[n];
        int currF = 0;
        for(int i=0; i<n; i++) {
            char c = dominoes.charAt(i);
            if(c == 'R') {
                currF = n;
            } else if (c == 'L') {
                currF = 0;
            } else {
                currF = Math.max(currF - 1, 0);
            }
            force[i] = currF;
        }

        currF = 0;
        for(int i=n-1; i>=0; i--) {
            char c = dominoes.charAt(i);
            if(c == 'R') {
                currF = 0;
            } else if (c == 'L') {
                currF = n;
            } else {
                currF = Math.max(currF - 1, 0);
            }
            force[i] -= currF;
        }

        char[] ans = dominoes.toCharArray();
        for(int i=0; i<n; i++) {
            if(force[i] < 0) {
                ans[i] = 'L';
            } else if (force[i] > 0) {
                ans[i] = 'R';
            } else {
                ans[i] = '.';
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(pushDominoesQuality("L.....RR.RL.....L.R."));
    }
}
