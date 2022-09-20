package lc75l2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void swap(List<Integer> curr, int a, int b) {
        int temp = curr.get(a);
        curr.set(a, curr.get(b));
        curr.set(b, temp);
    }

    public static void permutationHelper(int[] nums, List<List<Integer>> res, int index, List<Integer> curr) {
        if(index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(curr, index, i);
            permutationHelper(nums, res, index + 1, curr);
            swap(curr, index, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int num : nums) {
            curr.add(num);
        }

        permutationHelper(nums, res, 0, curr);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> op = permute(new int[] {1,2});
        System.out.println('a');
    }
}
