package bs2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public static int binarySearchInsert(int[] nums, int target) {
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        int[] starts = new int[intervals.length];
        int[] res = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            startIndexMap.put(intervals[i][0], i);
        }

        Arrays.sort(starts);

        for(int i=0; i<intervals.length; i++) {
            int reqStartIndex = binarySearchInsert(starts, intervals[i][1]);

            if(reqStartIndex == starts.length) {
                res[i] = -1;
            } else {
                res[i] = startIndexMap.get(starts[reqStartIndex]);
            }
        }

        return res;
    }

    public int[] findRightInterval2(int[][] intervals) {
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        for(int i=0; i<intervals.length; i++) {
            startMap.put(intervals[i][0], i);
        }

        int[] res = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            Integer key = startMap.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1 : startMap.get(key);
        }

        return res;
    }
}
