package Scaler.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    List<List<Integer>> res;

    public void helper(int[] A, int index, List<Integer> curr) {
        if(index == A.length) return;

        curr.add(A[index]);
        res.add(new ArrayList<>(curr));
        helper(A, index + 1, curr);

        curr.remove(curr.size() - 1);
        helper(A, index + 1, curr);
    }

    public int[][] subsets(int[] A) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(A);
        helper(A, 0, new ArrayList<>());

        int[][] ans = new int[res.size()][];
        for(int i=0; i<ans.length; i++) {
            List<Integer> curr = res.get(i);
            ans[i] = new int[curr.size()];
            for(int j=0; j<ans[i].length; j++) {
                ans[i][j] = curr.get(j);
            }
        }

        return ans;
    }
}
