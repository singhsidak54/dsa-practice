package daily.jan23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day20NonDecreasingSubsequences {
    static Set<List<Integer>> result;

    public static void subsequencesDFS(List<Integer> currList, int index, int[] nums) {
        if(currList.size() >= 2) {
            result.add(new ArrayList<>(currList));
        }

        if(index == nums.length) return;

        // without considering current element
        subsequencesDFS(currList, index + 1, nums);

        // should we consider current element?
        if(currList.size() > 0 && currList.get(currList.size() - 1) > nums[index]) return;

        // with considering current element
        currList.add(nums[index]);
        subsequencesDFS(currList, index + 1, nums);
        currList.remove(currList.size() - 1);
    }

    public static List<List<Integer>> findSubsequencesBruteForce(int[] nums) {
        result = new HashSet<>();
        subsequencesDFS(new ArrayList<>(), 0, nums);

        return result.stream().toList();
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> result = findSubsequencesBruteForce(nums);
        System.out.println(result);
    }
}
