package lc75l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void combinationSumHelper(int[] candidates, int target, List<Integer> currList, List<List<Integer>> res, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }


        for(int i=index; i<candidates.length; i++) {
            if(target - candidates[i] < 0) return;

            currList.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], currList, res, i);
            currList.remove(currList.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }


}
