package bs1;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer> temp = new ArrayList<>();
        for(int num : nums2) {
            if(map.getOrDefault(num,0) > 0) {
                map.put(num, map.get(num) - 1);
                temp.add(num);
            }
        }

        int[] sol = new int[temp.size()];
        for(int i=0; i<temp.size(); i++) {
            sol[i] = temp.get(i);
        }
        return sol;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> solution = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                solution.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] sol = new int[solution.size()];
        for(int k=0; k<solution.size(); k++) {
            sol[k] = solution.get(k);
        }
        return sol;
    }
}
