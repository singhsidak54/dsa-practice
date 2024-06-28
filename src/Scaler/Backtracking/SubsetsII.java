package Scaler.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res;

    public void helper(int[] A, int index, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        if(index == A.length) return;

        for(int i=index; i<A.length; i++) {
            if(i > index && A[i] == A[i - 1]) continue;

            curr.add(A[i]);
            helper(A, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public int[][] subsetsWithDup(int[] A) {
        res = new ArrayList<>();
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

    public static void main(String[] args) {
        int[] A = {1,2,2};
        SubsetsII obj = new SubsetsII();
        int[][] ans = obj.subsetsWithDup(A);
        System.out.println(Arrays.toString(ans));
    }
}
