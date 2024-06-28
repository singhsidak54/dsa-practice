package Scaler.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllUniquePermutationsAlternate {
    List<List<Integer>> res;

    public void helper(int size, List<Integer> curr, HashMap<Integer, Integer> counter) {
        if(curr.size() == size) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer key = entry.getKey(), count = entry.getValue();
            if(count == 0) continue;

            // add
            curr.add(key);
            counter.put(key, count - 1);
            helper(size, curr, counter);


            // remove
            curr.remove(curr.size() - 1);
            counter.put(key, count);
        }

    }

    public int[][] permute(int[] A) {
        res = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        helper(A.length, new ArrayList<>(), counter);

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
