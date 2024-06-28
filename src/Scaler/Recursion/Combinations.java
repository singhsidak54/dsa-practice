package Scaler.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    List<List<Integer>> res;

    public void backtrack(int curr, int left, int max, List<Integer> comb) {
        if(left == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if(max - curr + 1 < left) {
            return;
        }

        // include
        comb.add(curr);
        backtrack(curr + 1, left - 1, max, comb);
        comb.remove(comb.size() - 1);

        // skip
        backtrack(curr + 1, left, max, comb);
    }
    public int[][] combine(int A, int B) {
        res = new ArrayList<>();
        backtrack(1, B, A, new ArrayList<>());
        int[][] ans = new int[res.size()][B];
        for(int i=0; i<ans.length; i++) {
            ans[i] = new int[B];
            for(int j=0; j<B; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(Arrays.toString(obj.combine(4, 2)));
    }
}
