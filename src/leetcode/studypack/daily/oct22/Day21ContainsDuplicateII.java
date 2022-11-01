package daily.oct22;

import java.util.*;

public class Day21ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                List<Integer> temp = map.get(nums[i]);
                for(int j : temp) {
                    if(Math.abs(j - i) <= k) return true;
                }
                temp.add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int i=0, j=0;
        Set<Integer> set = new HashSet<>();
        for(; j<=k && j<nums.length; j++) {
            if(set.contains(nums[j])) {
                return true;
            }
            set.add(nums[j]);
        }

        for(; j<nums.length; j++) {
            set.remove(nums[i++]);
            if(set.contains(nums[j])) {
                return true;
            }
            set.add(nums[j]);
        }

        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);

            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
