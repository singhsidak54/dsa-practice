package contests.w316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfOperationsToMakeArraysSimilar {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        List<Integer> oddsNum = new ArrayList<>(), oddsTarget = new ArrayList<>();
        List<Integer> evensNum = new ArrayList<>(), evensTarget = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 0) {
                evensNum.add(nums[i]);
            } else {
                oddsNum.add(nums[i]);
            }

            if(target[i] % 2 == 0) {
                evensTarget.add(target[i]);
            } else {
                oddsTarget.add(target[i]);
            }
        }

        long ans = 0;
        for(int i=0; i<evensNum.size(); i++) {
            if(evensNum.get(i) < evensTarget.get(i)) {
                ans += (evensTarget.get(i) - evensNum.get(i))/2;
            }
        }

        for(int i=0; i<oddsNum.size(); i++) {
            if(oddsNum.get(i) < oddsTarget.get(i)) {
                ans += (oddsTarget.get(i) - oddsNum.get(i))/2;
            }
        }

        return ans;
    }
}
