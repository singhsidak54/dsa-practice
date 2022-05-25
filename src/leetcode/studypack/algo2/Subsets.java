package algo2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
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
            currList.add(nums[i]);
            subsetsHelper(nums, i + 1, currList, subsetsList);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
