package Scaler.Arrays;

import java.util.ArrayList;

public class Flip {
    public static ArrayList<Integer> flip(String A) {
        int[] arr = new int[A.length()];
        int count = 0;
        for(int i=0; i<A.length(); i++) {
            arr[i] = A.charAt(i) == '0' ? 1 : -1;
            if(A.charAt(i) == '1') {
                count++;
            }
        }

        ArrayList<Integer> ans = new ArrayList();
        if(count == 0) {
            ans.add(1);
            ans.add(A.length());
            return ans;
        } else if(count == A.length()) {
            return ans;
        }

        int ansS = 0, ansE = 0;
        int s = 0, max = 0, curr = 0;
        for(int e=0; e<arr.length; e++) {
            curr += arr[e];

            if(curr < 0) {
                s = e + 1;
                curr = 0;
            } else if (curr > max) {
                max = curr;
                ansS = s + 1;
                ansE = e + 1;
            }
        }

        ans.add(ansS);
        ans.add(ansE);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(flip("1101"));
    }
}
