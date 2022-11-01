package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public void permuteHelper(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                permuteHelper(nums, visited, curr, result);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, visited, new ArrayList<>(), result);
        return result;
    }
}
