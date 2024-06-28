package Scaler.Recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    List<int[]> res;

    public void backtrack(int disc, int from, int to, int aux) {
        if(disc == 0) {
            return;
        }

        backtrack(disc - 1, from, aux, to);
        res.add(new int[] {disc, from, to});
        backtrack(disc - 1, aux, to, from);
    }

    public int[][] towerOfHanoi(int A) {
        res = new ArrayList<>();
        backtrack(A, 1, 3, 2);
        int[][] ans = new int[res.size()][3];
        for(int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
