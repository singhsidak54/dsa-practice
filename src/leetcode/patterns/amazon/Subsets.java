package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public void subsetsHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> curr) {
        if(index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        subsetsHelper(nums, index + 1, result, curr);
        curr.add(nums[index]);
        subsetsHelper(nums, index + 1, result, curr);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, result, new ArrayList<>());
        return result;
    }
}
