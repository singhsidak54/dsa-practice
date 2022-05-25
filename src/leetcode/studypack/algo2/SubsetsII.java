package algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetList = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<>(), subsetList);
        return subsetList;
    }

    public static void subsetsHelper(int[] nums, int start, List<Integer> currList, List<List<Integer>> subsetsList) {
        subsetsList.add(new ArrayList<>(currList));
        if(start == nums.length) {
            return;
        }
        for(int i=start; i<nums.length; i++) {
            if(i > start && nums[i-1] == nums[i]) continue;
            currList.add(nums[i]);
            subsetsHelper(nums, i + 1, currList, subsetsList);
            currList.remove(currList.size() - 1);
        }
    }
}
