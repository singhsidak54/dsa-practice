package algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    public static void permuteHelper(int[] nums, List<Integer> currList, List<List<Integer>> result, boolean[] visited) {
        if(currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]) {
                continue;
            }

            if(!visited[i]) {
                visited[i] = true;
                currList.add(nums[i]);
                permuteHelper(nums, currList, result, visited);
                currList.remove(currList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
