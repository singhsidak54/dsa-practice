package Scaler.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> res;

    public void helper(int[] A, List<Integer> curr, boolean[] visited) {
        if(curr.size() == A.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(A[i]);
                helper(A, curr, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }

    public int[][] permute(int[] A) {
        res = new ArrayList<>();
        helper(A, new ArrayList<>(), new boolean[A.length]);

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
