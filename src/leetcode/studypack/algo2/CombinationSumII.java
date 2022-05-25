package algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void combinationSum2Helper(int[] candidates, int target, int start, List<Integer> currList, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(target - candidates[i] < 0) {
                break;
            }
            currList.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
