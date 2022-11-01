package patterns.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if(nums[i] == i - 1) {
                i++;
            } else {
                int temp = nums[i];
                if(nums[temp - 1] == temp) {
                    set.add(temp);
                    i++;
                } else {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
        }

        return set.stream().toList();
    }


    public List<Integer> findDuplicatesOptimised(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }

        return res;
    }
}
