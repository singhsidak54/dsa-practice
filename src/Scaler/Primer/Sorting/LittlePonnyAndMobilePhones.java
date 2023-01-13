package Scaler.Primer.Sorting;

import java.util.ArrayList;

public class LittlePonnyAndMobilePhones {
    public int binarySearchJustGreater(int[] arr, int query) {
        int l = 0, r = arr.length, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] > query) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] prefixSum = new int[A.size()];
        prefixSum[0] = A.get(0);
        for(int i=1; i<A.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i);
        }

        for(int query : B) {
            ans.add(binarySearchJustGreater(prefixSum, query));
        }

        return ans;
    }
}
