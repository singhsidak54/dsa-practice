package patterns.intuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> res = new ArrayList<>();

        int currStart = intervals[0][0], currEnd = intervals[0][1], i = 1, n = intervals.length;
        while (i < n) {
            if(intervals[i][0] <= currEnd) {
                currEnd = Math.max(intervals[i][1], currEnd);
            } else {
                res.add(new int[] {currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
            i++;
        }

        res.add(new int[] {currStart, currEnd});

        int[][] ans = new int[res.size()][2];
        for(i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
