package Scaler.Primer.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class LittlePonnyAndMaximumElement {
    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        int l = 0, r = A.size() - 1, m;
        while (l < r) {
            m = l + (r - l)/2 + 1;
            if(A.get(m) > B) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        return A.get(l) == B ? A.size() - l - 1 : -1;
    }

    public static void main(String[] args) {
        int[] arr = {24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50 };
        ArrayList<Integer> A = new ArrayList<>();
        for(int a : arr) {
            A.add(a);
        }
        System.out.println(solve(A, 13));
    }
}
