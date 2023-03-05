package contests.w334;

import java.util.*;

public class Q3 {
    public static int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }

        int ans = 0;
        Arrays.sort(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int mid = n % 2 == 0 ? n/2 - 1 : n/2;

        for(int i=mid+1; i<n; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        while (mid >= 0) {
            int toMark = nums[mid] * 2;
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(toMark);
            if(entry == null) {
                treeMap.put(nums[mid], treeMap.getOrDefault(nums[mid], 0) + 1);
            } else {
                ans += 2;
                if(entry.getValue() == 1) {
                    treeMap.remove(entry.getKey());
                } else {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            mid--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40};

        System.out.println(maxNumOfMarkedIndices(nums));
    }
}
