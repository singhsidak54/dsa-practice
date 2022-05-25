package algo2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if(result.size() == 149 || target < 0) {
            return;
        } else if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
