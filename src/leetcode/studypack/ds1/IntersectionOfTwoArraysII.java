package leetcode.studypack.ds1;

import java.util.*;

// Problem Link - https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
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

    public static void main(String[] args) {
        int[] a = {1,2,2,4};
        int[] b = {6,2,3};

        System.out.println(Arrays.toString(intersect(b, a)));
    }
}
