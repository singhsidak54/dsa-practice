package patterns.amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
